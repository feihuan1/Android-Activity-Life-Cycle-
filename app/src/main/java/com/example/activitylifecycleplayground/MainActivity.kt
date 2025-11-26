package com.example.activitylifecycleplayground

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonExit.setOnClickListener {
            showDialog()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.editTextMessage.text
//        File(filesDir, "user message.txt").writeText(userMessage.toString())
//    }

    private fun showDialog(){
        AlertDialog.Builder(this)
            .setTitle("Warning")
//            .setMessage("Are you sure you want exit the app!!!")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("yes") {_, _ ->
                finish()
            }
            .setNegativeButton("No") {dialog,_ ->
                dialog.dismiss()
            }
            .setNeutralButton("Neutral"){_,_,->
                Toast.makeText(this, "this is where the more info screen could be", Toast.LENGTH_LONG).show()

            }
            .show()

    }
}