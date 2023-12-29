package com.brainvire.learning

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        GlobalScope.launch {
//            simpleCollector()
//            collectorEvents()
//            collectNotes()
        }

        /*
                GlobalScope.launch {
                    delay(3500)
                    jobCollect.cancel()
                }
        */

//        doFlowOn()
//        sharedFlowCollectors()
//        stateFlowCollectors()
//        flatMapConcatOperator()
        flatMapConcatOperator()
    }

    private fun simpleFlow() = flow<Int> {
        val list = listOf<Int>(1, 2, 3, 4, 5)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }.catch {
        Log.d(TAG, "simpleFlowProducer: Error occurred during emit")
        emit(-1)
    }

    private suspend fun simpleCollector() {
        simpleFlow().collect {
            Log.d(TAG, "simpleCollector: collector running:- $it")
        }
    }

    private suspend fun collectorEvents() {
        simpleFlow().onStart {
            emit(0)
            Log.d(TAG, "collectorEvents: collector onStart")
        }.onCompletion {
            emit(6)
            Log.d(TAG, "collectorEvents: collector onCompletion")
        }.onEach {
            Log.d(TAG, "collectorEvents: collector onEach:- $it")
        }.collect {
            Log.d(TAG, "collectorEvents: collector running:- $it")
        }
    }

    data class Note(val id: Int, val isActive: Boolean, val title: String, val desc: String)

    data class FormattedNote(
        val id: Int,
        val isActive: Boolean,
        val title: String,
        val desc: String
    )

    private fun getNotes(): Flow<Note> {
        return listOf(
            Note(id = 1, isActive = true, title = "Mercedes", desc = "This is Mercedes"),
            Note(id = 2, isActive = false, title = "BMW", desc = "This is BMW"),
            Note(id = 3, isActive = true, title = "Audi", desc = "This is Audi"),
        ).asFlow()
    }

    private suspend fun collectNotes() {
        getNotes()
            .map {
                FormattedNote(
                    id = it.id,
                    isActive = it.isActive,
                    title = it.title.uppercase(),
                    desc = it.desc
                )
            }
            .filter { it.isActive }
            .collect {
                Log.d(TAG, "collectNotes: $it")
            }
    }

    private fun doFlowOn() {

        GlobalScope.launch(Dispatchers.Main) {
            try {
                simpleFlow()
                    .map {
                        it * 2
                    }
                    .flowOn(Dispatchers.Main)
                    .filter {
                        it < 5
                    }
                    .flowOn(Dispatchers.IO)
                    .collect {
                        Log.d(TAG, "simpleCollector: collector running:- $it")
                        Toast.makeText(this@FlowActivity, it.toString(), Toast.LENGTH_SHORT).show()
                    }
            } catch (e: Exception) {
                Log.d(TAG, "simpleFlowProducer: Error occurred during collect")
            }
        }
    }

    private fun simpleSharedFlow(): Flow<Int> {

        val mutableSharedFlow = MutableSharedFlow<Int>()
        val list = listOf(1, 2, 3, 4, 5)
        GlobalScope.launch {
            list.forEach {
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }

        return mutableSharedFlow
    }

    private fun sharedFlowCollectors() {

        GlobalScope.launch {
            val result = simpleSharedFlow()
            result.collect {
                Log.d(TAG, "sharedFlowCollector: collector 1 running:- $it")
            }
        }

        GlobalScope.launch {
            val result = simpleSharedFlow()
            delay(2500)
            result.collect {
                Log.d(TAG, "sharedFlowCollector: collector 2 running:- $it")
            }
        }
    }

    private fun simpleStateFlow(): Flow<Int> {

        val mutableStateFlow = MutableStateFlow(10)
        val list = listOf(1, 2, 3, 4, 5)
        GlobalScope.launch {
            list.forEach {
                mutableStateFlow.emit(it)
                delay(1000)
            }
        }

        return mutableStateFlow
    }

    private fun stateFlowCollectors() {

        GlobalScope.launch {
            val result = simpleStateFlow()
            delay(7000)
            result.collect {
                Log.d(TAG, "stateFlowCollectors: collector running:- $it")
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun flatMapConcatOperator() {
        GlobalScope.launch {
            (1..5)
                .asFlow()
                .onEach { delay(1000) }
                .flatMapConcat {
                    flowOf("Number is: $it")
                }
                .collect{
                    Log.d(TAG, "flatMapConcatOperator: $it")
                }
        }
    }
}