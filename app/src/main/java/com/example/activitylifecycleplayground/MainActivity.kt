package com.example.activitylifecycleplayground

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private var isFirstLoad = true
    private var numberOfLoads = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewRefreshStatus.text = "welcome to the App, Here is your feed..."

        binding.buttonExit.setOnClickListener {
            finish()
        }
    }
//     No 1 place for refreshing data
    override fun onResume() {
        super.onResume()
        numberOfLoads += 1
    }

    override fun onRestart() {
        super.onRestart()
        binding.textViewRefreshStatus.text = "updated $numberOfLoads times"
    }


}