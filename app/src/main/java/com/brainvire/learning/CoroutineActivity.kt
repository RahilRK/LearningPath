package com.brainvire.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield
import kotlin.math.log

class CoroutineActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

//        simpleCoroutineLaunch()
        CoroutineScope(Dispatchers.Default).launch {
//            useDelay()
//            useYieldTaskOne()
//            useYieldTaskTwo()
//            getFollowers()
//            parentChildRelation()
//            withContextTest()
            runBlockingTest()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun simpleCoroutineLaunch() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "CoroutineScope: ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "GlobalScope: ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "MainScope: ${Thread.currentThread().name}")
        }
    }


    /*use 'delay' to suspend any task for some time*/
    private suspend fun useDelay() {
        Log.d(TAG, "Task 1: START")
        delay(2000)
        Log.d(TAG, "Task 1: END")
    }

    /*use 'yield' to suspend any task for some time*/
    private suspend fun useYieldTaskOne() {
        Log.d(TAG, "Task 1: START")
        yield()
        Log.d(TAG, "Task 1: END")
    }

    private suspend fun useYieldTaskTwo() {
        Log.d(TAG, "Task 2: START")
        yield()
        Log.d(TAG, "Task 2: END")
    }


    private suspend fun getFollowers() {
        val job1 = CoroutineScope(Dispatchers.IO).async {
            getInstagramFollower()
        }
        val job2 = CoroutineScope(Dispatchers.IO).async {
            getFBFollower()
        }

        Log.d(TAG, "getFollowers: Instagram: ${job1.await()}, FB: ${job2.await()}")
    }

    private suspend fun getInstagramFollower(): Int {
        delay(1000)
        return 54
    }

    private suspend fun getFBFollower(): Int {
        delay(1000)
        return 138
    }

    private suspend fun parentChildRelation() {
        val parentJob = GlobalScope.launch {
            Log.d(TAG, "Parent started")

            val childJob = launch {
                Log.d(TAG, "Child started")
                delay(5000)
                Log.d(TAG, "Child ended")
            }

            delay(1000)
            Log.d(TAG, "Parent ended")
        }

        parentJob.join()
        Log.d(TAG, "Parent completed")
    }

    /*this will block until running delay*/
    private suspend fun withContextTest() {
        Log.d(TAG, "withContext: started")
        withContext(Dispatchers.IO){
            Log.d(TAG, "withContext: running")
            delay(1000)
        }

        Log.d(TAG, "withContext: ended")
    }


    private suspend fun runBlockingTest() {
        runBlocking {
            launch {
                delay(1000)
                Log.d(TAG, "Hello")
            }
            Log.d(TAG, "World")
        }
    }
}