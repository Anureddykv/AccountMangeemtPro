package com.fincare.accmangement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fincare.accmangement.data.AccountRepository
import com.fincare.accmangement.db.Account
import kotlinx.coroutines.launch

class AccountViewModel(private val repository: AccountRepository) : ViewModel() {

   fun saveAccounts(accounts: List<Account>) = viewModelScope.launch {
      repository.insertAccounts(accounts)
   }

   fun getAllAccounts(callback: (List<Account>) -> Unit) = viewModelScope.launch {
      val accounts = repository.getAllAccounts()
      callback(accounts)
   }

   fun updateAlternateName(actId: String, alternateName: String) {
      viewModelScope.launch {
         repository.updateAlternateName(actId, alternateName)
      }
   }

   fun deleteAccount(account: Account) = viewModelScope.launch {
      repository.deleteAccount(account)
   }
}
