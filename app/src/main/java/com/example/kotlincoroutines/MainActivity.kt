package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.click.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                //coroutine scope is an interface defines it's scope,global scope is used to handle top level coroutine
                //dispatchers describe the kind of thread
                //IO dispatcher used to work in background thread....
                //launch enables a new coroutine without suspending the current but without returning any value
                // to return value we use async
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData() {

        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text="Downloading user $i in ${Thread.currentThread().name}"
            }

            //Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
    }
