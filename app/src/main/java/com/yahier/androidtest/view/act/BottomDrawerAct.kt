package com.yahier.androidtest.view.act

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import android.widget.RelativeLayout
import com.yahier.androidtest.BaseActivity
import com.yahier.androidtest.R
import kotlinx.android.synthetic.main.act_bottom_drawer.*

/**
 * 底部抽屉
 */
public class BottomDrawerAct : BaseActivity() {

     private lateinit var behavior: BottomSheetBehavior<RelativeLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_bottom_drawer)
        init()

    }

    fun init() {
        behavior = BottomSheetBehavior.from(bottom_sheet)
        behavior.isHideable = false

        val callback = object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //Log.d("$tag onSlide", "slideOffset:" + slideOffset)
            }

            var state = BottomSheetBehavior.STATE_COLLAPSED
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        viewHand.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 80)
                        recyclerView.visibility = View.VISIBLE
                        horizontalView.visibility = View.GONE

                        //LogUtils.logE(tag, "STATE_DRAGGING")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        state = BottomSheetBehavior.STATE_SETTLING
                        //LogUtils.logE(tag, "STATE_SETTLING")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        state = BottomSheetBehavior.STATE_EXPANDED
                        //LogUtils.logE(tag, "STATE_EXPANDED")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        viewHand.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,250)

                        recyclerView.visibility = View.GONE
                        horizontalView.visibility = View.VISIBLE
                        state = BottomSheetBehavior.STATE_COLLAPSED
                        //LogUtils.logE(tag, "STATE_DRAGGING")
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        state = BottomSheetBehavior.STATE_HIDDEN
                        //LogUtils.logE(tag, "STATE_DRAGGING")
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        state = BottomSheetBehavior.STATE_HALF_EXPANDED
                        // LogUtils.logE(tag, "STATE_HALF_EXPANDED")
                    }
                }
                state = newState
            }
        }

        behavior.setBottomSheetCallback(callback)
    }

}