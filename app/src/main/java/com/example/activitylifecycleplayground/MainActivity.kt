package com.example.activitylifecycleplayground

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_exit).setOnClickListener {
            Log.d("Feihuan", "in button click listener!!")
            finish()
        }
        Log.d("Feihuan", "This is OnCreate!!")
    }

    override fun onDestroy() {
        Log.d("Feihuan", "This is OnDestroy!!")
        super.onDestroy()
    }

}