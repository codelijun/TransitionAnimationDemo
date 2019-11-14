package com.annotation.transitionanimationdemo.content_transition

import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ContentTransitionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
        val style = 1
        when (style) {
            1 -> {
                val explode =
                    TransitionInflater.from(this).inflateTransition(android.R.transition.explode)
                explode.duration = 1000
                window.enterTransition = explode
            }

            2 -> {
                val slide = Slide()
                slide.slideEdge = Gravity.END
                slide.duration = 1000
                window.enterTransition = slide
            }
        }
    }
}