package com.annotation.transitionanimationdemo.compat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R
import com.annotation.transitionanimationdemo.compat.transition.CySharedElementTransition

class CompatDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_image_detail)
        //共享元素动画
        CySharedElementTransition.runEnterAnim(this)
    }

    override fun onBackPressed() {
        CySharedElementTransition.finishActivityWithAnim(this)
    }
}