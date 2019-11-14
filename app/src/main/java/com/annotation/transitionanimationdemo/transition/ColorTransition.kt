package com.annotation.transitionanimationdemo.transition

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.transition.Transition
import android.transition.TransitionValues
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.annotation.transitionanimationdemo.BuildConfig

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
class ColorTransition(private val mStartColor: Int, private val mEndColor: Int) : Transition() {
    companion object {
        private const val COLOR_BACKGROUND = "ColorTransition:change_color:background"
        private const val TAG = "ColorTransition"
        private val DEBUG = BuildConfig.DEBUG
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        transitionValues.values[COLOR_BACKGROUND] = mStartColor
        if (DEBUG) {
            Log.d(TAG, "captureStartValues() view== ${transitionValues.view}")
        }
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        transitionValues.values[COLOR_BACKGROUND] = mEndColor
        if (DEBUG) {
            Log.d(TAG, "captureEndValues() view== ${transitionValues.view}")
        }
    }

    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        if (null == startValues || null == endValues) {
            return null
        }
        Log.d(
            "ColorTransition",
            "createAnimator() mEndColor== $mEndColor mStartColor== $mStartColor"
        )
        val view = endValues.view

        val drawable = view.background
        val startColor = startValues.values[COLOR_BACKGROUND] as Int
        val endColor = endValues.values[COLOR_BACKGROUND] as Int

        if (startColor != endColor) {
            val startRed = Color.red(startColor)
            val endRed = Color.red(endColor)
            val startGreen = Color.green(startColor)
            val endGreen = Color.green(endColor)
            val startBlue = Color.blue(startColor)
            val endBlue = Color.blue(endColor)
            val animator = ValueAnimator.ofFloat(0f, 1f)
            animator.addUpdateListener { animation ->
                val value = animation.animatedValue as Float
                val red = (startRed + (endRed - startRed) * value).toInt()
                val green = (startGreen + (endGreen - startGreen) * value).toInt()
                val blue = (startBlue + (endBlue - startBlue) * value).toInt()
                val color = Color.argb(255, red, green, blue)
                if (drawable is GradientDrawable) {
                    drawable.setColor(color)
                }
            }
            return animator
        }
        return null
    }
}
