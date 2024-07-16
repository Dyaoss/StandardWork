package com.example.mytossclone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytossclone.databinding.ActivityTransferViewBinding

class TransferView : AppCompatActivity() {
    private val binding by lazy { ActivityTransferViewBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val secondDataList = mutableListOf<MySendItem>()
        secondDataList.add(MySendItem(R.drawable.icon_tossbank, "토스뱅크 통장", 213234))
        secondDataList.add(MySendItem(R.drawable.icon_kb, "국민은행 통장", 10000000))
        secondDataList.add(MySendItem(R.drawable.icon_nh, "농협은행 통장", 500))
        secondDataList.add(MySendItem(R.drawable.icon_ibk, "IBK 기업은행 통장", 0))
        secondDataList.add(MySendItem(R.drawable.icon_kakao, "카카오뱅크 통장", 1228390))
        secondDataList.add(MySendItem(R.drawable.icon_keb, "하나은행 통장", 12233000))
        secondDataList.add(MySendItem(R.drawable.icon_sinha, "신한은행 통장", 34000))

        val adapter = MySecondAdapter(secondDataList)
        binding.recyclerview2.adapter = adapter
        binding.recyclerview2.layoutManager = LinearLayoutManager(this)

        binding.ivLeftArrow.setOnClickListener {
            finish()
        }



    }
}