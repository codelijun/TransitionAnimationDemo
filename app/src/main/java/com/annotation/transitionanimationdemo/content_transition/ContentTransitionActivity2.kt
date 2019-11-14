package com.annotation.transitionanimationdemo.content_transition

import android.os.Build
import android.os.Bundle
import android.transition.Explode
import android.transition.TransitionInflater
import android.transition.TransitionSet
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ContentTransitionActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
        val transitionSet = TransitionSet()

        val fade = TransitionInflater.from(this).inflateTransition(android.R.transition.fade)
        fade.duration = 1000
        transitionSet.addTransition(fade)

        val explode = Explode()
        explode.duration = 1000
        explode.excludeTarget(R.id.third_view_5, true)
        transitionSet.addTransition(explode)

        window.enterTransition = transitionSet
    }
}