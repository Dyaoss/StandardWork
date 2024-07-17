package com.example.mytossclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytossclone.databinding.ItemRecyclerviewBinding
import java.text.DecimalFormat

class MyAdapter(val myItems: MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        val dec = DecimalFormat("#,###")

        holder.iconImageView.setImageResource(myItems[position].aIcon)
        holder.name.text = myItems[position].aName
        holder.deposit.setText("${dec.format(myItems[position].aDeposit)}원")
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.bankLogo
        val name = binding.bankName
        val deposit = binding.deposit
    }

}