package com.annotation.transitionanimationdemo.compat.transition

import android.animation.Animator
import android.animation.TimeInterpolator
import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.LinearInterpolator

object CySharedElementTransition {
    private const val TRANSITION_MATERIALS = "TRANSITION_MATERIALS"
    private const val DEFAULT_TRANSITION_DURATION: Long = 240
    private val DEFAULT_TIME_INTERPOLATOR: TimeInterpolator = LinearInterpolator()


    fun startActivity(intent: Intent, activity: Activity, vararg views: View) {
        startActivityForResult(intent, -1, activity, *views)
    }

    fun startActivityForResult(
        intent: Intent,
        requestCode: Int,
        activity: Activity,
        vararg views: View
    ) {
        val materials = TransitionMaterials.createMaterials(*views)
        intent.putParcelableArrayListExtra(TRANSITION_MATERIALS, materials.viewAttrs)
        activity.startActivityForResult(intent, requestCode)
        activity.overridePendingTransition(0, 0)//Disable system default transition animation
    }

    fun runEnterAnim(activity: Activity, listener: Animator.AnimatorListener) {
        runEnterAnim(activity, DEFAULT_TRANSITION_DURATION, DEFAULT_TIME_INTERPOLATOR, listener)
    }

    fun runEnterAnim(activity: Activity, duration: Long, listener: Animator.AnimatorListener) {
        runEnterAnim(activity, duration, DEFAULT_TIME_INTERPOLATOR, listener)
    }

    /**
     * 界面进入过渡动画
     *
     * @param activity
     * @param duration
     * @param interpolator
     * @param listener
     */
    @JvmOverloads
    fun runEnterAnim(
        activity: Activity,
        duration: Long = DEFAULT_TRANSITION_DURATION,
        interpolator: TimeInterpolator = DEFAULT_TIME_INTERPOLATOR,
        listener: Animator.AnimatorListener? = null
    ) {
        val attrs = activity.intent.getParcelableArrayListExtra<ViewAttrs>(TRANSITION_MATERIALS)
        if (null == attrs || attrs.isEmpty()) {
            return
        }

        for (attr in attrs) {
            val view = activity.findViewById<View>(attr.id) ?: continue
            view.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    view.viewTreeObserver.removeOnPreDrawListener(this)

                    val location = IntArray(2)
                    view.getLocationOnScreen(location)
                    view.pivotX = 0f
                    view.pivotY = 0f
                    view.translationX = (attr.screenX - location[0]).toFloat()
                    view.translationY = (attr.screenY - location[1]).toFloat()
                    view.scaleX = attr.width * 1.00f / view.width
                    view.scaleY = attr.height * 1.00f / view.height
                    view.alpha = attr.alpha

                    val srcAlpha = view.alpha
                    view.animate().alpha(srcAlpha)
                        .translationX(0f)
                        .translationY(0f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(duration)
                        .setInterpolator(interpolator)
                        .setListener(listener)
                        .start()
                    return true
                }
            })
        }
    }

    fun finishActivityWithAnim(
        activity: Activity,
        duration: Long,
        listener: Animator.AnimatorListener
    ) {
        finishActivityWithAnim(activity, duration, DEFAULT_TIME_INTERPOLATOR, listener)
    }

    /**
     * 界面退出还原动画
     *
     * @param activity
     * @param duration
     * @param interpolator
     * @param listener
     */
    @JvmOverloads
    fun finishActivityWithAnim(
        activity: Activity,
        duration: Long = DEFAULT_TRANSITION_DURATION,
        interpolator: TimeInterpolator = DEFAULT_TIME_INTERPOLATOR,
        listener: Animator.AnimatorListener? = null
    ) {
        val attrs = activity.intent.getParcelableArrayListExtra<ViewAttrs>(TRANSITION_MATERIALS)
        if (null == attrs || attrs.isEmpty()) {
            activity.finish()//v1.0.1版本添加，防止没有过度元素当前Activity关闭不了，开放系统自带过度动画
            return
        }

        for (attr in attrs) {
            val view = activity.findViewById<View>(attr.id) ?: continue

            val location = IntArray(2)
            view.getLocationOnScreen(location)
            view.pivotX = 0f
            view.pivotY = 0f

            view.animate().alpha(attr.alpha)
                .translationX((attr.screenX - location[0]).toFloat())
                .translationY((attr.screenY - location[1]).toFloat())
                .scaleX(attr.width * 1.00f / view.width)
                .scaleY(attr.height * 1.00f / view.height)
                .setDuration(duration)
                .setInterpolator(interpolator)
                .setListener(listener)
                .start()
        }
        Handler().postDelayed({
            activity.finish()
            activity.overridePendingTransition(0, 0)//Disable system default transition animation
        }, duration)
    }
}