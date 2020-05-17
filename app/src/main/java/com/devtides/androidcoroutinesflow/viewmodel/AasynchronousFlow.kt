package com.devtides.androidcoroutinesflow.viewmodel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
fun main() {
    runBlocking {
        val tickerChannel = ticker(100,10)
        launch {
            val startTime = System.currentTimeMillis()
            tickerChannel.consumeEach {
                val delta = System.currentTimeMillis() - startTime
                println("Received tick after $delta")
            }
        }

        delay(1000)
        println("Done!")
        tickerChannel.cancel()
    }
}