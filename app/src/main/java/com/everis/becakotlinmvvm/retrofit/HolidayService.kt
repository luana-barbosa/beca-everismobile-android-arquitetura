package com.everis.becakotlinmvvm.retrofit

import com.everis.becakotlinmvvm.model.HolidayModel
import retrofit2.Call
import retrofit2.http.GET

interface HolidayService {

    @GET("PublicHolidays/2021/br")
    fun getHolidays(): Call<List<HolidayModel>>
}