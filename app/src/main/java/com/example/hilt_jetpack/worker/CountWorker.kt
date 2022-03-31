package com.example.hilt_jetpack.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class CountWorker @AssistedInject constructor(
    @Assisted context: Context ,
    @Assisted workerParameters: WorkerParameters
) : Worker(context,workerParameters) {

    override fun doWork(): Result {
        for (i in 1..100){
            Log.i("Work Progress", i.toString())
        }
        return Result.success()
    }
}