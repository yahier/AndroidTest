package com.yahier.androidtest.util

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class UploadWorker(val appContext: Context, val workerParams: WorkerParameters) : Worker(appContext, workerParams) {


    override fun doWork(): Result {
        try {
            uploadImages(workerParams)
            return Result.success()
        } catch (e: Exception) {

        }
        return Result.retry()
    }


    private fun uploadImages(workerParams: WorkerParameters) {
        val tagSet = workerParams.tags
        Log.e("UploadWorker", "执行任务 $tagSet dateTime:" + getNow())
    }


    private fun getNow(): String {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())
        } else {
            val tms = Calendar.getInstance()
            return tms.get(Calendar.YEAR).toString() + "-" + tms.get(Calendar.MONTH).toString() + "-" + tms.get(Calendar.DAY_OF_MONTH).toString() + " " + tms.get(Calendar.HOUR_OF_DAY).toString() + ":" + tms.get(Calendar.MINUTE).toString() + ":" + tms.get(Calendar.SECOND).toString() + "." + tms.get(Calendar.MILLISECOND).toString()
        }
    }

}