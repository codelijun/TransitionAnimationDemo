package com.annotation.transitionanimationdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.annotation.transitionanimationdemo.animation_style.NormalTransitionActivity
import com.annotation.transitionanimationdemo.compat.CompatTransitionActivity
import com.annotation.transitionanimationdemo.content_transition.ContentTransitionActivity
import com.annotation.transitionanimationdemo.content_transition.ContentTransitionActivity2
import com.annotation.transitionanimationdemo.share_element.image.ShareElementImageActivity
import com.annotation.transitionanimationdemo.share_element.view.ShareElementViewActivity
import com.annotation.transitionanimationdemo.system_inner.SystemInnerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //简单style类型的转场动画
        start_second_activity.setOnClickListener {
            val intent = Intent(this, NormalTransitionActivity::class.java)
            startActivity(intent)
        }

        //内容变化转场动画（简单）
        start_third_activity.setOnClickListener {
            val intent = Intent(this, ContentTransitionActivity::class.java)
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
            startActivity(intent, activityOptionsCompat.toBundle())
        }

        //内容变化转场动画（复杂）
        start_fourth_activity.setOnClickListener {
            val intent = Intent(this, ContentTransitionActivity2::class.java)
            val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this)
            startActivity(intent, activityOptionsCompat.toBundle())
        }

        //共享元素之图片共享
        start_fifth_activity.setOnClickListener {
            val intent = Intent(this, ShareElementImageActivity::class.java)
            startActivity(intent)
        }

        //共享元素之View共享
        start_sixth_activity.setOnClickListener {
            val intent = Intent(this, ShareElementViewActivity::class.java)
            startActivity(intent)
        }

//        //共享元素动画监听
//        start_seventh_activity.setOnClickListener {
//            val intent = Intent(this, ShareElementListActivity::class.java)
//            startActivity(intent)
//        }

        //系统内置的效果
        start_eighth_activity.setOnClickListener {
            val intent = Intent(this, SystemInnerActivity::class.java)
            startActivity(intent)
        }

        start_ninth_activity.setOnClickListener {
            val intent = Intent(this, CompatTransitionActivity::class.java)
            startActivity(intent)
        }
    }
}
