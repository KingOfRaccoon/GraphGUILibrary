package com.example.graphguilibrary

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = Model(this, 4, this)
        addContentView(model, ViewGroup.LayoutParams(resources.displayMetrics.widthPixels, resources.displayMetrics.heightPixels))
    }
}