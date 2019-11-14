package com.annotation.transitionanimationdemo.animation_style

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.annotation.transitionanimationdemo.R
import kotlinx.android.synthetic.main.activity_second.*

class NormalTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        start_new_activity.setOnClickListener {
            val intent = Intent(this, StyleAnimationActivity::class.java)
            startActivity(intent)
        }

        start_new_dialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog =
            AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("I am a dialog")
                .setPositiveButton("确定") { _, _ ->
                }.create()
        dialog.window?.setWindowAnimations(R.style.WindowAnimation)
        dialog.show()
    }
}