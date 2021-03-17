package com.yahier.androidtest.download

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.MediaPlayerTest
import com.yahier.androidtest.R
import com.yahier.androidtest.common.MyApp
import kotlinx.android.synthetic.main.act_download.*
import java.io.File


/**
 * 参考 https://developer.android.google.cn/reference/android/app/DownloadManager?hl=en
 * 自带断点续传，同一个文件下载种不再次启动下载。
 * downloadManager的下载是基于系统的，即使app退出，下载仍然进行
 *
 *
 */
class DownloadManagerTestAct : BaseActivity() {

    final val TAG = "DownloadManagerTestAct";

    var fileUrl = "http://192.168.8.48:8080/static/test_10s.mp4" //a file on my server
    //var fileUrl2 = "http://192.168.8.48:8080/static/refund_finish.mp3"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_download)
        //init()
        check()
    }


    private fun activePlay(filePath: String) {
        btnStart.setOnClickListener {
            val intent = Intent(this, MediaPlayerTest::class.java)
            intent.putExtra("videoPath", filePath)
            startActivity(intent)
        }
    }

    private fun check() {
        val sp = getSp()
        val downloadId = sp.getLong(fileUrl, 0L)
        if (downloadId == 0L) {
            //准备去下载
            tvResult.text = "第一次 准备去下载"
            startDownload()
        } else {
            //查询对应的downloadId
            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

            val localFilePath = getLocalFilePath(downloadManager, downloadId)

            if (localFilePath != null) {
                val file = File(localFilePath)
                if (file.exists()) {
                    tvResult.text = "文件存在。可以播放视频啦 $localFilePath"
                    activePlay(localFilePath)
                } else {
                    tvResult.text = "文件好像被删掉了，准备重新开始下载"
                    startDownload()
                }
            } else {
                //还在下载中，等待吧
                tvResult.text = "还在下载中，等一会儿再来看"
            }


        }

    }


    private fun getSp(): SharedPreferences {
        return MyApp.getContext().getSharedPreferences("download", Context.MODE_PRIVATE)
    }


    private fun startDownload() {
        val request = DownloadManager.Request(Uri.parse(fileUrl))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)//不用设置了，默认所有网络都允许下载
        //需要在manifest种android.permission.DOWNLOAD_WITHOUT_NOTIFICATION
        //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN)

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getFileName())

        val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        //todo step1 执行下载  记录下这个downloadId
        val downloadId = downloadManager.enqueue(request)

        //记录 url——downloadId
        getSp().edit().putLong(fileUrl, downloadId).apply()
    }


    private fun init() {
        val request = DownloadManager.Request(Uri.parse(fileUrl))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)//不用设置了，默认所有网络都允许下载

        //需要在manifest种android.permission.DOWNLOAD_WITHOUT_NOTIFICATION
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN)

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, getFileName())

        val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        //todo step1 执行下载  记录下这个downloadId
        val downloadId = downloadManager.enqueue(request)

        Log.e(TAG, "fileUrl is $fileUrl,下载id是 $downloadId")
        checkStatus(downloadManager, downloadId)

        btn1.text = "fileUrl is $fileUrl,下载id是 $downloadId"
    }


    private fun getFileName(): String {
        return "test_10s.mp4"
    }


    private fun checkStatus(downloadManager: DownloadManager, downloadId: Long) {
        val query = DownloadManager.Query().setFilterById(downloadId)
        val c = downloadManager.query(query)

        if (c != null && c.moveToFirst()) {
            //1.要得到下载完成的文件路径
            val localURI = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
            //下载等待时，路径也是有值的
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
                    //getSp().edit().putString(downloadId.toString(), localURI).apply()

                }
                DownloadManager.STATUS_FAILED -> {
                    Log.e(TAG, "下载失败")
                }
            }
        }
    }


    private fun getLocalFilePath(downloadManager: DownloadManager, downloadId: Long): String? {
        val query = DownloadManager.Query().setFilterById(downloadId)
        var localPath: String? = null
        val cursor = downloadManager.query(query)
        if (cursor != null && cursor.moveToFirst()) {
            val status = cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_STATUS))
            when (status) {
                DownloadManager.STATUS_SUCCESSFUL -> {
                    //1.要得到下载完成的文件路径
                    val localFileUri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
                    //下载等待时，路径也是有值的


                    tvResult.text = "下载成功了 localURI is $localFileUri"
                    Log.e(TAG, "下载成功了 localURI is $localFileUri")

                    localPath = getRealPathFromURI(this, Uri.parse(localFileUri))
                    tvResult.text = "下载成功了 localPath is $localPath"
                    Log.e(TAG, "下载成功了 localPath is $localPath")
                }
            }
        }

        return localPath
    }


    fun getRealPathFromURI(context: Context, contentURI: Uri): String? {
        val result: String
        val cursor: Cursor? = context.contentResolver.query(contentURI, arrayOf(MediaStore.Images.ImageColumns.DATA),  //
                null, null, null)
        if (cursor == null) result = contentURI.path else {
            cursor.moveToFirst()
            val index: Int = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            result = cursor.getString(index)
            cursor.close()
        }
        return result
    }

}