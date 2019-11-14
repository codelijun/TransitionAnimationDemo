package com.annotation.transitionanimationdemo.animation_style

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class StyleAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = FrameLayout(this)
        contentView.setBackgroundColor(Color.CYAN)

        val itemView = View(this)
        itemView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400)
        itemView.setBackgroundColor(Color.DKGRAY)
        contentView.addView(itemView)
        setContentView(contentView)
    }
}