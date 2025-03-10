package com.fincare.accmangement.ui

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.Manifest
import android.app.Activity
import androidx.core.app.ActivityCompat
import com.fincare.accmangement.db.Account
import com.fincare.accmangement.db.AccountDatabase
import com.fincare.accmangement.data.AccountRepository
import com.fincare.accmangement.R
import com.fincare.accmangement.data.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val staticData = listOf(
        Account(1,"Static Account 1", "101"),
        Account(2,"Static Account 2", "102"),
        Account(3,"Static Account 3", "103")
    )
    private val REQUEST_CODE_ALTERNATE_NAME = 200
    private lateinit var accountDatabase: AccountDatabase
    private lateinit var accountRepository: AccountRepository
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accountDatabase = AccountDatabase.getInstance(this)
        accountRepository = AccountRepository(accountDatabase.accountDao())


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchAccounts { accounts ->
            CoroutineScope(Dispatchers.IO).launch {
                accountRepository.clearAccounts()
                accountRepository.insertAccounts(accounts)
                val savedAccounts = accountRepository.getAllAccounts()

                runOnUiThread {
                    recyclerView.adapter = AccountAdapter(savedAccounts.toMutableList(),
                        onEditClick = { account ->
                            val intent = Intent(this@MainActivity, AlternateNameActivity::class.java).apply {
                                putExtra("account_id", account.actid)
                                putExtra("account_name", account.ActName)
                            }
                            startActivityForResult(intent, REQUEST_CODE_ALTERNATE_NAME)
                        },
                        onDeleteClick = { account ->
                            deleteAccount(account)
                        }
                    )
                }
            }
        }

        findViewById<Button>(R.id.btnOpenPdf).setOnClickListener {
            val pdfUrl =
                "https://fssservices.bookxpert.co/GeneratedPDF/Companies/nadc/2024-2025/BalanceSheet.pdf"
            if (checkPermission()) {
                downloadAndOpenPDF(pdfUrl)
            } else {
                requestPermission()
            }
        }

        findViewById<Button>(R.id.btnOpenImageCapture).setOnClickListener {
            val intent = Intent(this, ImageCaptureActivity::class.java)
            startActivity(intent)
        }

    }
    private fun checkPermission(): Boolean {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                101
            )
        }
    }

    @SuppressLint("Range")
    private fun downloadAndOpenPDF(pdfUrl: String) {
        val request = DownloadManager.Request(Uri.parse(pdfUrl))
            .setTitle("Balance Sheet")
            .setDescription("Downloading PDF...")
            .setDestinationInExternalFilesDir(this, "pdfs", "BalanceSheet.pdf")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = downloadManager.enqueue(request)

        val query = DownloadManager.Query().setFilterById(downloadId)
        Thread {
            var downloading = true
            while (downloading) {
                val cursor = downloadManager.query(query)
                if (cursor.moveToFirst()) {
                    val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                    if (status == DownloadManager.STATUS_SUCCESSFUL) {
                        downloading = false
                        val fileUri = downloadManager.getUriForDownloadedFile(downloadId)
                        openPDF(fileUri)
                    }
                }
                cursor.close()
            }
        }.start()
    }

    private fun openPDF(uri: Uri?) {
        uri?.let {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(it, "application/pdf")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(intent)
        } ?: run {
            Toast.makeText(this, "Failed to open PDF", Toast.LENGTH_SHORT).show()
        }
    }


    private fun fetchAccounts(callback: (List<Account>) -> Unit) {
        RetrofitInstance.api.getAccountsAsString().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    response.body()?.let { responseBody ->
                        try {
                            val accounts = Gson().fromJson(responseBody, Array<Account>::class.java).toList()
                            if (accounts.isNotEmpty()) {
                                callback(accounts)
                            } else {
                                Log.e("API_ERROR", "Empty data, using static data.")
                                callback(staticData)
                            }
                        } catch (e: JsonSyntaxException) {
                            Log.e("API_ERROR", "JSON Parsing Error: ${e.message}")
                            callback(staticData)
                        }
                    } ?: run {
                        Log.e("API_ERROR", "Response body is null")
                        callback(staticData)
                    }
                } else {
                    Log.e("API_ERROR", "Status Code: ${response.code()} - ${response.message()}")
                    callback(staticData)
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("API_ERROR", "Network Failure: ${t.message}")
                callback(staticData)
            }
        })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_ALTERNATE_NAME && resultCode == Activity.RESULT_OK) {
            val accountId = data?.getStringExtra("account_id") ?: return
            val alternateName = data?.getStringExtra("alternate_name") ?: return

            CoroutineScope(Dispatchers.IO).launch {
                accountRepository.updateAlternateName(accountId, alternateName)

                val updatedAccounts = accountRepository.getAllAccounts()
                runOnUiThread {
                    (recyclerView.adapter as? AccountAdapter)?.updateData(updatedAccounts)
                    Toast.makeText(this@MainActivity, "Alternate name updated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun deleteAccount(account: Account) {
        CoroutineScope(Dispatchers.IO).launch {
            accountRepository.deleteAccount(account)

            val updatedAccounts = accountRepository.getAllAccounts()
            runOnUiThread {
                (recyclerView.adapter as? AccountAdapter)?.updateData(updatedAccounts)
                Toast.makeText(this@MainActivity, "Account deleted", Toast.LENGTH_SHORT).show()
            }
        }
    }


}

