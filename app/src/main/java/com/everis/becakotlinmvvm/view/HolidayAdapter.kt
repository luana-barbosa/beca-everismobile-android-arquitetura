package com.everis.becakotlinmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.everis.becakotlinmvvm.BR
import com.everis.becakotlinmvvm.R
import com.everis.becakotlinmvvm.databinding.ItemHolidayBinding
import com.everis.becakotlinmvvm.model.HolidayModel

class HolidayAdapter() : RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    var holidayList: List<HolidayModel>

    init {
        holidayList = ArrayList()
    }

    fun addData(arrList: List<HolidayModel>){
        this.holidayList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
        val binding: ItemHolidayBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_holiday, parent, false)

        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ItemHolidayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.model, data)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return holidayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(holidayList.get(pos))
    }
}