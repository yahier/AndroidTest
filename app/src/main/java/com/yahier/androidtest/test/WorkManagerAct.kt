package com.yahier.androidtest.test

import android.os.Build
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.R
import com.yahier.androidtest.util.UploadWorker
import kotlinx.android.synthetic.main.act_work_manager.*
import java.util.concurrent.TimeUnit

/**
 * 在真机和模拟器上的测试效果不同
 */
class WorkManagerAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_work_manager)
        initViews()
    }

    private fun initViews() {
        //立即执行一个 无需条件的 任务
        btnStartWork.setOnClickListener {
            //val worker = UploadWorker(this,null)
            val workRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
            WorkManager.getInstance().enqueue(workRequest)
        }


        //立即执行 一个需要满足条件的任务
        btnStartWork2.setOnClickListener {
            if(Build.VERSION.SDK_INT>23){
//                val constraints = Constraints.Builder().setRequiresDeviceIdle(true).setRequiresCharging(true).build()
//                val workRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).setConstraints(constraints).setPeriodStartTime(30,TimeUnit.SECONDS)
//
//                WorkManager.getInstance().enqueue(workRequest)
            }

        }


        //执行一个延迟任务
        // 测试1，启动任何后 删除app 没有执行任务
        //测试2   启动任务后，杀死进程， 模拟器(app的application类被唤醒了 任务执行了) 真机啥反应都没有
        //测试3  启动任务后，重启设备，不开启app,时间到期后，任务没有执行，打开app后 任务才执行
        btnStartWork3.setOnClickListener {
            val workRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).setInitialDelay(1, TimeUnit.MINUTES).build()
            WorkManager.getInstance().enqueue(workRequest)
        }

    }


    /***
     * 周期性任务 https://developer.android.google.cn/reference/androidx/work/PeriodicWorkRequest?hl=en
     * 最短仍然需要15分钟的间隔 并且因为dezo mode的缘故，执行施行并不准确
     */
    fun testRepeat(){
        val request = PeriodicWorkRequest.Builder(UploadWorker::class.java,15,TimeUnit.MINUTES).build()

    }


}