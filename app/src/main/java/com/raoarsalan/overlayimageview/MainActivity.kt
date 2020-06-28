package com.raoarsalan.overlayimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var overlayImageView:OverlayImageView
    private lateinit var changeColorBtn: AppCompatButton
    private lateinit var resetBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        overlayImageView = findViewById(R.id.overlayIv)
        changeColorBtn = findViewById(R.id.color_btn)
        resetBtn = findViewById(R.id.reset_btn)

        changeColorBtn.setOnClickListener {
            overlayImageView.setOverlayColor(ContextCompat.getColor(this,R.color.black_40_opacity))
        }

        resetBtn.setOnClickListener {
            overlayImageView.setOverlayColor(overlayImageView.getDefaultColor())
        }
    }
}