package com.yahier.androidtest.test

import android.os.Build
import android.os.Bundle
import androidx.work.*
import com.google.common.util.concurrent.ListenableFuture
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.R
import com.yahier.androidtest.util.UploadWorker
import kotlinx.android.synthetic.main.act_work_manager.*
import java.util.concurrent.TimeUnit

/**
 * 官方文档: https://developer.android.google.cn/topic/libraries/architecture/workmanager/how-to/define-work?hl=zh_cn
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
            testOneTimeWork()
        }


        //立即执行 一个需要满足条件的任务
        btnStartWork2.setOnClickListener {
            testSomeConditionWork()
        }


        //执行一个延迟任务
        // 测试1，启动任何后 删除app 没有执行任务
        //测试2   启动任务后，杀死进程， 模拟器(app的application类被唤醒了 任务执行了) 真机啥反应都没有
        //测试3  启动任务后，重启设备，不开启app,时间到期后，任务没有执行，打开app后 任务才执行
        btnStartWork3.setOnClickListener {
            testRepeat()
        }

    }


    /**
     * 试验 简单的一次性任务
     */
    private fun testOneTimeWork() {

        val workRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).addTag("一次性实时任务").setInitialDelay(10, TimeUnit.SECONDS).build()


        WorkManager.getInstance().enqueue(workRequest)

        //唯一性工作。
        WorkManager.getInstance().enqueueUniqueWork("唯一性标记", ExistingWorkPolicy.REPLACE, workRequest)
    }


    /**
     * 试验满足条件的方法
     */
    private fun testSomeConditionWork() {
        val constraints = Constraints.Builder().setRequiresCharging(true).build()
        val workRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).addTag("条件性任务").setConstraints(constraints).build()
        WorkManager.getInstance().enqueue(workRequest)
    }


    /***
     * 周期性任务 https://developer.android.google.cn/reference/androidx/work/PeriodicWorkRequest?hl=en
     * 最短仍然需要15分钟的间隔 并且因为dezo mode的缘故，执行施行并不准确
     */
    private fun testRepeat() {
        val request = PeriodicWorkRequest.Builder(UploadWorker::class.java, 15, TimeUnit.MINUTES).build()


    }


    public fun otherMethods() {
        val futureWork: ListenableFuture<List<WorkInfo>> = WorkManager.getInstance().getWorkInfosByTag("条件性任务")
        val listWork = futureWork.get(3,TimeUnit.SECONDS)


        //val workss = WorkManager.getInstance().getWorkInfoById("ss")
        val operation = WorkManager.getInstance().cancelAllWorkByTag("")
        operation.state
        val isdone = operation.result.isDone





    }


}