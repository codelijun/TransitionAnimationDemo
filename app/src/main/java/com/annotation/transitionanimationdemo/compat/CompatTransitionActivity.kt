package com.annotation.transitionanimationdemo.compat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R
import com.annotation.transitionanimationdemo.compat.transition.CySharedElementTransition
import kotlinx.android.synthetic.main.activity_share_element_image.*

class CompatTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_element_image)
        share_element_image_view.setOnClickListener {
            val intent =
                Intent(this@CompatTransitionActivity, CompatDetailActivity::class.java)
            CySharedElementTransition.startActivity(
                intent,
                this@CompatTransitionActivity,
                share_element_image_view
            )
        }
    }
}