package com.example.mytossclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytossclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.icon_tossbank, "토스뱅크 통장", 213234))
        dataList.add(MyItem(R.drawable.icon_kb, "국민은행 통장", 10000000))
        dataList.add(MyItem(R.drawable.icon_nh, "농협은행 통장", 500))
        dataList.add(MyItem(R.drawable.icon_ibk, "IBK 기업은행 통장", 0))
        dataList.add(MyItem(R.drawable.icon_kakao, "카카오뱅크 통장", 1228390))
        dataList.add(MyItem(R.drawable.icon_keb, "하나은행 통장", 12233000))
        dataList.add(MyItem(R.drawable.icon_sinha, "신한은행 통장", 34000))

        val adapter = MyAdapter(dataList)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)


        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, TransferView::class.java)
                startActivity(intent)
            }
        }
    }
}