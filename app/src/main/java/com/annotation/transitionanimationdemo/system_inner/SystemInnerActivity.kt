package com.annotation.transitionanimationdemo.system_inner

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.graphics.drawable.toBitmap
import com.annotation.transitionanimationdemo.R
import com.annotation.transitionanimationdemo.animation_style.StyleAnimationActivity
import kotlinx.android.synthetic.main.activity_system_inner.*

class SystemInnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_inner)
        scale_up_btn.setOnClickListener {
            val intent = Intent(this, StyleAnimationActivity::class.java)
            val activityOptionsCompat =
                ActivityOptionsCompat.makeScaleUpAnimation(it, it.width / 2, it.height / 2, 0, 0)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
        clip_reveal_btn.setOnClickListener {
            val intent = Intent(this, StyleAnimationActivity::class.java)
            val activityOptionsCompat =
                ActivityOptionsCompat.makeClipRevealAnimation(it, it.width / 2, it.height / 2,0, 0)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
        thumbnail_scale_up_btn.setOnClickListener {
            val intent = Intent(this, StyleAnimationActivity::class.java)
            val drawable: Drawable = resources.getDrawable(R.mipmap.ic_launcher_round)
            val activityOptionsCompat =
                ActivityOptionsCompat.makeThumbnailScaleUpAnimation(it, drawable.toBitmap(), it.width / 2, it.height / 2)
            startActivity(intent, activityOptionsCompat.toBundle())
        }
    }
}