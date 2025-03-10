package com.fincare.accmangement.data.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Fillaccounts/nadc/2024-2025")
    fun getAccountsAsString(): Call<String>
}

