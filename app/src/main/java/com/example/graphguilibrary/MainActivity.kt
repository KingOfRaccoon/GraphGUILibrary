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
//        val draw2D = Draw2D(this, resources.displayMetrics, TestData.list.size)
//        Toast.makeText(this, "${resources.displayMetrics.heightPixels}" +
//                "\n" +
//                "${resources.displayMetrics.widthPixels}", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_main)
//        val draw = findViewById<Draw2D>(R.id.draw)
//        val node = Node(PointF(250f, 250f), 100f, this)
        val canvas = Canvas()
        val model = TestModel(this, 4)
        addContentView(model, ViewGroup.LayoutParams(1000, 1000))
        val testNiceCreatorGraph = TestNiceCreatorGraph(model)
        testNiceCreatorGraph.createNiceGraph(model.nodes, 1000f, 1000f)
//        addContentView(node, ViewGroup.LayoutParams(1000, 1000))
//        node.setOnClickListener {
//            Log.d("Test", TestData.list[0].toString())
//        }
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.frame, MainFragment(4))
//                .commit()
//    }
    }
}