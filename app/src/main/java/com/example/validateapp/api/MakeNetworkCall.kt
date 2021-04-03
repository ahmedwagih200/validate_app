package com.example.validateapp.api

import android.util.Log
import com.example.validateapp.data.Rules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MakeNetworkCall(private val listener: GetTheResponse) {
    private var rules =Rules()
    private val retrofit = Retrofit.Builder()
        .baseUrl(RulesApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private  val service = retrofit.create(RulesApi::class.java)

    fun getTheRule(){
        CoroutineScope(Dispatchers.IO).launch {
            val response1 = service.getRules()
            withContext(Dispatchers.Main){
                if (response1.isSuccessful) {
                    rules= response1.body()!!
                    listener.getResponse(rules)
                }else{
                    Log.e("RETROFIT_ERROR", response1.code().toString())
                }
            }
        }
    }
     interface GetTheResponse{
         fun getResponse(rules: Rules)
     }
}
