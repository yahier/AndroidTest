package com.yahier.androidtest.util

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.
        uploadImages()
        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }


    private fun uploadImages() {
        Log.e("UploadWorker", "执行任务 uploadImages")
    }
}