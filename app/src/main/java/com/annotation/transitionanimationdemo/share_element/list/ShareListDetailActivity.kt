package com.annotation.transitionanimationdemo.share_element.list

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ShareListDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = ImageView(this)
        setContentView(contentView)
    }
}