package com.fincare.accmangement.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fincare.accmangement.R
import com.fincare.accmangement.db.Account

class AccountAdapter(private var accounts: MutableList<Account>,
                     private val onEditClick: (Account) -> Unit,
                     private val onDeleteClick: (Account) -> Unit) :
    RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    class AccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.txtAccountName)
        val idTextView: TextView = view.findViewById(R.id.txtAccountId)
        val btnEdit: ImageButton = view.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_account, parent, false)
        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account = accounts[position]

        holder.nameTextView.text = account.ActName
        holder.idTextView.text = "ID: ${account.actid}"
        holder.btnEdit.setOnClickListener { onEditClick(account) }
        holder.btnDelete.setOnClickListener { onDeleteClick(account) }
    }


    override fun getItemCount() = accounts.size

    fun updateData(newAccounts: List<Account>) {
        accounts.clear()
        accounts.addAll(newAccounts)
        notifyDataSetChanged()
    }
}
