package com.example.graphguilibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.PointF
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet

@SuppressLint("ViewConstructor")
class Model(context: Context, var quantity: Int, var canvas: Canvas):ViewGroup(context){
    val nodes = mutableListOf<Node>()
    val lines = mutableListOf<Line>()
//    lateinit var node: Node
    init {
        for (i in 0 until quantity){
            nodes.add(
            Node(PointF((0..context.resources.displayMetrics.widthPixels).random().toFloat(), (0..context.resources.displayMetrics.heightPixels).random().toFloat()),
                    context.resources.displayMetrics.widthPixels / 40.toFloat(),
                            this.context,
                            TestData.list[i])
            )
//            Log.d("Test", node.data.toString())
//            node.setOnClickListener {
//                Log.d("Test", it.toString())
//            }
//            nodes.add(node)
        }

        for (i in 0 until quantity-1){
            lines.add(
                Line(
                    nodes[i],
                    nodes[i + 1],
                    this.context
                )
            )
        }
        nodes.forEach {
            this.addView(it)
        }

        lines.forEach {
            this.addView(it)
        }
        Log.d("Test", nodes.size.toString() + "\n" + lines.size.toString())
//        this.setOnClickListener{
//            onClick(it)
//        }
//        nodes.forEach{
//            it.setOnClickListener {
//                Log.d("Test", it.toString())
//            }
//        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        for (i in 0 until count){
            val view = getChildAt(i)
            view.layout(l, t, r, b)
        }
    }

    fun isContains(point: PointF, node: Node): Boolean {
        val dx = point.x - node.x
        val dy = point.y - node.y
        return dx*dx+dy*dy <= node.radius*node.radius
    }
}