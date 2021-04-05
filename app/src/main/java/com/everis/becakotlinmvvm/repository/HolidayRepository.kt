package com.everis.becakotlinmvvm.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.everis.becakotlinmvvm.model.HolidayModel
import com.everis.becakotlinmvvm.retrofit.HolidayService
import com.everis.becakotlinmvvm.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HolidayRepository {

    val TAG: String = javaClass.simpleName

    fun fetchHolidays(): MutableLiveData<List<HolidayModel>> {
        val mutableList: MutableLiveData<List<HolidayModel>> = MutableLiveData()

        val apiInterface = ApiService.getRetrofitInstance("https://date.nager.at/api/v2/")
            .create(HolidayService::class.java)

        apiInterface.getHolidays().enqueue(object : Callback<List<HolidayModel>> {
            override fun onResponse(
                call: Call<List<HolidayModel>>,
                response: Response<List<HolidayModel>>
            ) {
                Log.e(TAG, "onResponse response=" + response.toString())

                if (response.isSuccessful) {
                    Log.e(TAG, "onResponse response.size=" + response.body()?.size)

                    if (response.body() != null && response.body()?.size!! > 0) {
                        mutableList.value = response.body()!!
                    }
                }
            }

            override fun onFailure(call: Call<List<HolidayModel>>, t: Throwable) {
                Log.e(TAG, "onFailure call=" + call.toString())
            }

        })

        return mutableList
    }
}