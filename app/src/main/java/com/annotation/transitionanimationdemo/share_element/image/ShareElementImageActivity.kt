package com.annotation.transitionanimationdemo.share_element.image

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat

import com.annotation.transitionanimationdemo.R
import com.annotation.transitionanimationdemo.share_element.view.ShareElementViewDetailActivity
import kotlinx.android.synthetic.main.activity_share_element_image.*

class ShareElementImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_image)

        ViewCompat.setTransitionName(
            share_element_image_view,
            ShareElementViewDetailActivity.TRANSITION_NAME_SHARE_ITEM
        )
        share_element_image_view.setOnClickListener {
            val intent =
                Intent(this@ShareElementImageActivity, ShareElementImageDetailActivity::class.java)
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@ShareElementImageActivity,
                share_element_image_view,
                ShareElementImageDetailActivity.TRANSITION_NAME_SHARE_ITEM
            )
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}
