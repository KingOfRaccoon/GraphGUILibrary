package com.example.graphguilibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = Model(this, 4, this)
        addContentView(model, ViewGroup.LayoutParams(resources.displayMetrics.widthPixels, resources.displayMetrics.heightPixels))
//        val testNiceCreatorGraph = TestNiceCreatorGraph(model)
//        testNiceCreatorGraph.createNiceGraph(model.nodes, resources.displayMetrics.widthPixels.toFloat(), resources.displayMetrics.heightPixels.toFloat())
    }
}