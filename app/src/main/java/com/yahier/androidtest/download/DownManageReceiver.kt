package com.yahier.androidtest.download

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class DownManageReceiver : BroadcastReceiver() {

    val TAG = "DownManageReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {

        val action = intent?.action
        if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            Log.e(TAG, "下载成功")
        }

    }
}