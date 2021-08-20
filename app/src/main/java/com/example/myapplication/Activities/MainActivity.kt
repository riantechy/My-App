package com.example.myapplication.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.showToast
import com.google.android.material.snackbar.Snackbar

const val user_name = "com.example.myapplication"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
        binding.include.btn.setOnClickListener {
            Log.i("MainActivity", "Button Was clicked")
            showToast("Button was clicked")
        }
        binding.include.submit.setOnClickListener{
            val editText = findViewById<EditText>(R.id.name)
            val message = editText.text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply{
                putExtra(user_name, message)
            }
            startActivity(intent)
        }
        binding.include.share.setOnClickListener {
            val message: String = binding.include.name.text.toString()

            val intent =Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "plain/text"

            startActivity(Intent.createChooser(intent, "share to: "))
        }
        binding.include.btnCyl.setOnClickListener {
            val intent =Intent(this, HobbiesActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}