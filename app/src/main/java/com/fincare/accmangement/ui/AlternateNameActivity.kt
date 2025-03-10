package com.fincare.accmangement.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fincare.accmangement.R
import java.util.*

class AlternateNameActivity : AppCompatActivity() {

    private lateinit var editTextAlternateName: EditText
    private lateinit var btnSpeechToText: ImageButton
    private lateinit var txtSelectedAccount: TextView

    private var accountId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alternate_name)

        editTextAlternateName = findViewById(R.id.editTextAlternateName)
        btnSpeechToText = findViewById(R.id.btnSpeechToText)
        txtSelectedAccount = findViewById(R.id.txtSelectedAccount)

        accountId = intent.getStringExtra("account_id") ?: ""
        val accountName = intent.getStringExtra("account_name") ?: ""

        txtSelectedAccount.text = "Selected: $accountName (ID: $accountId)"

        Toast.makeText(this, "Selected: $accountName (ID: $accountId)", Toast.LENGTH_SHORT).show()

        btnSpeechToText.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now...")
            }
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
        }

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val alternateName = editTextAlternateName.text.toString().trim()
            if (alternateName.isNotEmpty()) {
                val resultIntent = Intent().apply {
                    putExtra("account_id", accountId)
                    putExtra("alternate_name", alternateName)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Please provide an alternate name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (!result.isNullOrEmpty()) {
                editTextAlternateName.setText(result[0])
            } else {
                Toast.makeText(this, "No speech input detected", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        private const val REQUEST_CODE_SPEECH_INPUT = 100
    }
}
