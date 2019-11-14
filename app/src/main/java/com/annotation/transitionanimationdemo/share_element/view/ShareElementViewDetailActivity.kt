package com.annotation.transitionanimationdemo.share_element.view

import android.os.Build
import android.os.Bundle
import android.transition.TransitionSet
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.annotation.transitionanimationdemo.R
import com.annotation.transitionanimationdemo.transition.ColorTransition
import com.annotation.transitionanimationdemo.transition.CornersTransition
import kotlinx.android.synthetic.main.activity_share_element_detail.*

class ShareElementViewDetailActivity : AppCompatActivity() {
    companion object {
        const val TRANSITION_NAME_SHARE_ITEM = "transition_name_share_item"
        const val TRANSITION_NAME_ROOT_VIEW = "transition_name_root_view"
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_detail)
        ViewCompat.setTransitionName(share_detail_item_view, TRANSITION_NAME_SHARE_ITEM)
        ViewCompat.setTransitionName(share_detail_root_view, TRANSITION_NAME_ROOT_VIEW)

        val transitionSet = TransitionSet()
        val cornersTransition = CornersTransition(200f, 0f)
        val colorTransition = ColorTransition(0x00ffff, 0xff9999)
        colorTransition.excludeTarget(share_detail_item_view, true)
        transitionSet.addTransition(window.sharedElementEnterTransition)
        transitionSet.addTransition(colorTransition)
        transitionSet.addTransition(cornersTransition)
        transitionSet.duration = 1000

        window.sharedElementEnterTransition = transitionSet
        window.sharedElementExitTransition

        val returnTransitionSet = TransitionSet()
        val returnCornersTransition = CornersTransition(0f, 200f)
        val returnColorTransition = ColorTransition(0xff9999, 0x00ffff)
        returnColorTransition.excludeTarget(share_detail_item_view, true)
        returnTransitionSet.addTransition(window.sharedElementReturnTransition)
        returnTransitionSet.addTransition(returnCornersTransition)
        returnTransitionSet.addTransition(returnColorTransition)
        returnTransitionSet.duration = 1000

        window.sharedElementReturnTransition = returnTransitionSet
    }
}