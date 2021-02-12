package com.example.kotlincoroutines

import kotlinx.coroutines.*

class UserDataMnager2 {
    var count = 0
    lateinit var deferred: Deferred<Int>
    suspend fun getTotalCount() : Int{


        coroutineScope {
            CoroutineScope(Dispatchers.IO).launch {
                delay(1000)
                count = 50
            }
            deferred = async(Dispatchers.IO ){
                        delay(1000)
                        return@async 70
                }

        }
        return count + deferred.await()
    }

}