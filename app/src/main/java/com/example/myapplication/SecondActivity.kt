package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.myapplication.databinding.ActivityMainBinding

class SecondActivity: AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val bundle:Bundle? = intent.extras
        val message = intent.getStringExtra(user_name)
        val textVew = findViewById<TextView>(R.id.user).apply{
            text = message
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
}