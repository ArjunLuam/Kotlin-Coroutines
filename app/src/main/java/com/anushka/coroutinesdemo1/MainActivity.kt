package com.anushka.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
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

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}
