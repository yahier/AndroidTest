package com.yahier.androidtest.vo


/**
 * 构想失败
 */
object DownloadManagerItem {
    //依次存储的是 serverFileUrl——downloadId——localFilePath
    private val listDown: List<Triple<String, Long, String>> = mutableListOf()

    public fun getTriangle(fileUrl: String): Triple<String, Long, String>? {
        return listDown.find { it.first == fileUrl }
    }


    public fun save(serverFileUrl: String, downloadId: String?, localFilePath: String?) {
        val item = getTriangle(serverFileUrl)
        item?.let {

            val second = downloadId ?: item.second
            //不能再赋值，构想失败
            //it.second = second

        }

    }


}