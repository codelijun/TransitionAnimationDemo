package com.annotation.transitionanimationdemo.share_element.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat

import com.annotation.transitionanimationdemo.R

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
class ShareElementViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_view)

        val itemView = findViewById<View>(R.id.share_element_item_view)
        val rootView = findViewById<View>(R.id.share_element_root_view)
        ViewCompat.setTransitionName(
            itemView,
            ShareElementViewDetailActivity.TRANSITION_NAME_SHARE_ITEM
        )
        ViewCompat.setTransitionName(
            rootView,
            ShareElementViewDetailActivity.TRANSITION_NAME_ROOT_VIEW
        )
        rootView.setOnClickListener {
            val intent =
                Intent(this@ShareElementViewActivity, ShareElementViewDetailActivity::class.java)
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this@ShareElementViewActivity, Pair.create(
                    itemView,
                    ShareElementViewDetailActivity.TRANSITION_NAME_SHARE_ITEM
                ), Pair.create(
                    rootView,
                    ShareElementViewDetailActivity.TRANSITION_NAME_ROOT_VIEW
                )
            )
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}
