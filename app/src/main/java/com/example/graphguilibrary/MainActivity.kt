package com.example.graphguilibrary

import android.graphics.Canvas
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.graphguilibrary.testModel.TestModel
import com.example.graphguilibrary.testModel.TestNiceCreatorGraph

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = Model(this, 4)
        addContentView(model, ViewGroup.LayoutParams(resources.displayMetrics.widthPixels, resources.displayMetrics.heightPixels))
        val testNiceCreatorGraph = TestNiceCreatorGraph(model)
        testNiceCreatorGraph.createNiceGraph(model.nodes, resources.displayMetrics.widthPixels.toFloat(), resources.displayMetrics.heightPixels.toFloat())
    }
}