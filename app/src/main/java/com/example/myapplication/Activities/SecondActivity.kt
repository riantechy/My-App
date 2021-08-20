package com.example.myapplication.Activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.showToast

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val bundle:Bundle? = intent.extras
        val message = intent.getStringExtra(user_name)
        message?.let {
            findViewById<TextView>(R.id.user).apply{
                text = message
                showToast(message)
        }
        }

    }
}