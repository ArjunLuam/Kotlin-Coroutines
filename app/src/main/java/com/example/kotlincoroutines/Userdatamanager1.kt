package com.example.kotlincoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Userdatamanager1 {
    suspend fun getTotalCount() : Int{
        var count = 0;
      val def =  CoroutineScope(IO).async {
            delay(1000)
            val count1=50
            return@async count1
        }
    return count + def.await()
    }
}