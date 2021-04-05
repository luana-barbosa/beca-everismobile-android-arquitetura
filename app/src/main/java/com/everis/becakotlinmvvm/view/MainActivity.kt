package com.everis.becakotlinmvvm.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.everis.becakotlinmvvm.viewmodel.HolidayViewModel
import com.everis.becakotlinmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    lateinit var holidayAdapter: HolidayAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        val holidayViewModel = HolidayViewModel()

        binding.progressBar.visibility = View.VISIBLE

        holidayViewModel.getHolidays().observe(this,
            { t ->
                Log.e(TAG, "observe onChanged()="+t?.size )
                binding.progressBar.visibility = View.GONE
                holidayAdapter.addData(t!!)
                holidayAdapter.notifyDataSetChanged()
            })
    }

    private fun initUI() {
        binding.rvHolidayList.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        binding.rvHolidayList.layoutManager = layoutManager
        binding.rvHolidayList.itemAnimator = DefaultItemAnimator()

        holidayAdapter = HolidayAdapter()
        binding.rvHolidayList.adapter = holidayAdapter
    }

}