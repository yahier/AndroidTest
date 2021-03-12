package com.yahier.androidtest.download

import android.app.DownloadManager
import android.content.Context
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.R


/**
 * 参考 https://developer.android.google.cn/reference/android/app/DownloadManager?hl=en
 * 自带断点续传，同一个文件下载种不再次启动下载
 */
class DownloadManagerTestAct : BaseActivity() {

    final val TAG = "DownloadManagerTestAct";

    val fileUrl = "http://192.168.8.48:8080/static/test_10s.mp4" //a file on my server

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_download)
        init()
    }


    private fun init() {
        val request = DownloadManager.Request(Uri.parse(fileUrl))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)//不用设置了，默认所有网络都允许下载

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        //fixme：ContextImp  Failed to ensure directory: /storage/sdcard1/Android/data/com.yahier/files/Download
        //request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, getFileName())

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getFileName())

        val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        //执行下载
        val downloadId = downloadManager.enqueue(request)
        Log.e(TAG, "下载id是 $downloadId")


        checkStatus(downloadManager, downloadId)

        //下载完成的回调
        val appDownReceiver = DownManageReceiver()
        registerReceiver(appDownReceiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))


        //todo 2.当前页面要unregister这个receiver
    }


    private fun getFileName(): String {
        return "12.mp4"
    }

    private fun checkStatus(downloadManager: DownloadManager, downloadId: Long) {
        val query = DownloadManager.Query().setFilterById(downloadId)
        val c = downloadManager.query(query)

        if (c != null && c.moveToFirst()) {

            //1.要得到下载完成的文件路径
            val localURI = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
            Log.e(TAG, "localURI is $localURI") //file:///storage/emulated/0/Download/12-6.mp4

            val status = c.getInt(c.getColumnIndexOrThrow(DownloadManager.COLUMN_STATUS))

            when (status) {
                DownloadManager.STATUS_PENDING -> {
                    Log.e(TAG, "下载等待")
                }

                DownloadManager.STATUS_PAUSED -> {
                    Log.e(TAG, "暂停")

                }
                DownloadManager.STATUS_RUNNING -> {
                    Log.e(TAG, "下载中")

                }
                DownloadManager.STATUS_SUCCESSFUL -> {
                    Log.e(TAG, "下载成功")

                }
                DownloadManager.STATUS_FAILED -> {
                    Log.e(TAG, "下载失败")
                }
            }
        }
    }

}