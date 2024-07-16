package com.example.mytossclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytossclone.databinding.ItemRecyclerviewSecondBinding

class MySecondAdapter(val mySecondItems: MutableList<MySendItem>) : RecyclerView.Adapter<MySecondAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySecondAdapter.Holder {
        val binding = ItemRecyclerviewSecondBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MySecondAdapter.Holder, position: Int) {
        holder.iconImageView.setImageResource(mySecondItems[position].bIcon)
        holder.name.text = mySecondItems[position].bName
        holder.account.text = mySecondItems[position].bAccount.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mySecondItems.size
    }

    inner class Holder(val binding: ItemRecyclerviewSecondBinding): RecyclerView.ViewHolder(binding.root){
        val iconImageView = binding.accountLogo
        val name = binding.accountName
        val account = binding.account
    }

}