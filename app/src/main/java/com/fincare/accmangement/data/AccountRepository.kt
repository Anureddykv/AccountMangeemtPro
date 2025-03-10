package com.fincare.accmangement.data

import com.fincare.accmangement.db.Account
import com.fincare.accmangement.db.AccountDao

class AccountRepository(private val accountDao: AccountDao) {

    suspend fun insertAccounts(accounts: List<Account>) = accountDao.insertAccounts(accounts)

    suspend fun getAllAccounts(): List<Account> = accountDao.getAllAccounts()

    suspend fun updateAlternateName(accountId: String, alternateName: String) {
        val account = accountDao.getAccountById(accountId)
        account?.let {
            val updatedAccount = it.copy(ActName = alternateName)
            accountDao.updateAccount(updatedAccount)
        }
    }

    suspend fun clearAccounts() = accountDao.clearAccounts()

    suspend fun deleteAccount(account: Account) {
        accountDao.deleteAccount(account)
    }
}

