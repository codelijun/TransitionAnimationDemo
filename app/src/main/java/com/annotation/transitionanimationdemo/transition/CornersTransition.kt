package com.annotation.transitionanimationdemo.transition

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.transition.Transition
import android.transition.TransitionValues
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.annotation.transitionanimationdemo.BuildConfig

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
class CornersTransition(private val mStartCorner: Float, private val mEndCorner: Float) :
    Transition() {
    companion object {
        private const val CORNERS_BACKGROUND = "CornersTransition:change_corners:background"
        private const val TAG = "CornersTransition"
        private val DEBUG = BuildConfig.DEBUG
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        transitionValues.values[CORNERS_BACKGROUND] = mStartCorner
        if (DEBUG) {
            Log.d(TAG, "captureStartValues() view== ${transitionValues.view}")
        }
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        transitionValues.values[CORNERS_BACKGROUND] = mEndCorner
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

        val view = endValues.view
        val drawable = view.background
        if (DEBUG) {
            Log.d(TAG, "createAnimator() boolean== ${drawable is GradientDrawable}")
        }
        if (drawable !is GradientDrawable) {
            return null
        }
        val startColor = startValues.values[CORNERS_BACKGROUND] as Float
        val endColor = endValues.values[CORNERS_BACKGROUND] as Float

        if (startColor != endColor) {
            val animator = ValueAnimator.ofFloat(startColor, endColor)
            animator.addUpdateListener { animation ->
                val value = animation.animatedValue as Float
                if (DEBUG) {
                    Log.d(TAG, "createAnimator() value== $value")
                }
                drawable.cornerRadius = value
            }
            return animator
        }
        return null
    }
}
