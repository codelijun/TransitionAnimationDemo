package com.annotation.transitionanimationdemo.animation_style

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R

class StyleWindowAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = FrameLayout(this)
        contentView.setBackgroundColor(Color.CYAN)
        val imageView = ImageView(this)
        imageView.setImageResource(R.mipmap.dark)

        val layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutParams.gravity = Gravity.CENTER
        imageView.layoutParams = layoutParams
        contentView.addView(imageView)
        setContentView(contentView)
    }
}