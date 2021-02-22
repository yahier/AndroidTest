package com.yahier.androidtest.ui.test

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.AppBarLayout
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.R


/**
 * MotionLayout定义MotionScene和translation让来模拟view的滚动
 */
class MotionLayoutAct : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step8_completed)

        coordinateMotion()
    }

    private fun coordinateMotion() {
        val appBarLayout: AppBarLayout = findViewById(R.id.appbar_layout)
        val motionLayout: MotionLayout = findViewById(R.id.motion_layout)

        val listener = AppBarLayout.OnOffsetChangedListener { unused, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition
        }

        appBarLayout.addOnOffsetChangedListener(listener)
    }
}
