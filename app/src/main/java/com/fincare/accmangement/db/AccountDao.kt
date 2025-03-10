package com.fincare.accmangement.db

import androidx.room.*

@Dao
interface AccountDao {

    @Query("SELECT * FROM accounts")
    suspend fun getAllAccounts(): List<Account>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccounts(accounts: List<Account>)

    @Query("SELECT * FROM accounts WHERE actid = :accountId LIMIT 1")
    suspend fun getAccountById(accountId: String): Account?

    @Query("UPDATE accounts SET alternateName = :alternateName WHERE actid = :actId")
    suspend fun updateAlternateName(actId: String, alternateName: String)
    @Update
    suspend fun updateAccount(account: Account)

    @Query("DELETE FROM accounts")
    suspend fun clearAccounts()
    @Delete
    suspend fun deleteAccount(account: Account)
}



