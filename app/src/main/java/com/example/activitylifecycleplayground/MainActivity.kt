package com.example.activitylifecycleplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonExit.setOnClickListener {
            Log.d("Feihuan", "in button click listener!!")
            startActivity(Intent(this, ANonFullScreenActivity::class.java))
        }
        Log.d("Feihuan", "This is OnCreate!!")
    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("Feihuan", "This is OnStart!!")
//    }
//
//    // usually refresh data
//    override fun onResume() {
//        super.onResume()
//        Log.d("Feihuan", "This is OnResume!!")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("Feihuan", "This is OnPause!!")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("Feihuan", "This is OnStop!!")
//    }
//
//    // onDestroy is not guarenteed to run
//    override fun onDestroy() {
//        Log.d("Feihuan", "This is OnDestroy!!")
//        super.onDestroy()
//    }

}