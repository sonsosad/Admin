package com.son.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnUser.setOnClickListener {

        }
        btnAddVideoShow.setOnClickListener {
            startActivity(Intent(this, AddVideoShow::class.java))
        }
        btnProduct.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
        btnCompany.setOnClickListener {
            startActivity(Intent(this, AddMap::class.java))

        }
        btnNews.setOnClickListener {
            startActivity(Intent(this, AddHealthNew::class.java))

        }
    }
}