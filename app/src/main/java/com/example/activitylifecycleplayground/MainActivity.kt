package com.example.activitylifecycleplayground

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity(), TestFragment.TestFragmentListener {
    private lateinit var binding: ActivityMainBinding
    private val testFragment = TestFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonExit.setOnClickListener {
            showDialog()
        }
        binding.buttonSave.setOnClickListener { saveMessage() }
        binding.buttonShowFragment.setOnClickListener { showFragment() }
        binding.buttonRemoveFragment.setOnClickListener { removeFragment() }
        binding.textViewSavedMessage.text = savedInstanceState?.getString("savedMessage")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextViewMessage = binding.textViewSavedMessage.text.toString()
        outState.putString("savedMessage", savedTextViewMessage)
    }

    private fun showFragment() {
        supportFragmentManager.commit {
            add(R.id.fragment_container, testFragment)
        }
    }

    private fun removeFragment() {
        supportFragmentManager.commit {
            remove(testFragment)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //**** when rotate phone, the activity will be destroyed and re-created!!! need save data!!!
    private fun MainActivity.saveMessage() {
        val userMessage = binding.editTextMessage.text
        File(filesDir, "user message.txt").writeText(userMessage.toString())
        binding.textViewSavedMessage.text = "your message has been saved! \n\nMessage Preview: \n\n$userMessage"
        binding.editTextMessage.setText("")
    }

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

    override fun clearActivityScreen() {
        binding.editTextMessage.setText("")
        binding.textViewSavedMessage.text = ""
        removeFragment()
    }

}
