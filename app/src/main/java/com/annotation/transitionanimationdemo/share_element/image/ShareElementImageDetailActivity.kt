package com.annotation.transitionanimationdemo.share_element.image

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.annotation.transitionanimationdemo.R
import kotlinx.android.synthetic.main.activity_share_element_image_detail.*

class ShareElementImageDetailActivity : AppCompatActivity() {
    companion object {
        const val TRANSITION_NAME_SHARE_ITEM = "transition_name_share_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_image_detail)
        ViewCompat.setTransitionName(share_element_image_view,
            TRANSITION_NAME_SHARE_ITEM
        )
    }
}