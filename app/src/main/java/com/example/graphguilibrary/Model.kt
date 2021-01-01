package com.example.graphguilibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.PointF
import android.util.Log
import android.view.ViewGroup
//import com.example.graphguilibrary.testModel.RedNode

@SuppressLint("ViewConstructor")
class Model(context: Context, quantity: Int):ViewGroup(context){
    var nodes = mutableListOf<NodeView>()
    val lines = mutableListOf<Line>()
    init {
        for (i in 0 until quantity){
            nodes.add(
                    NodeView(
                            PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                            1000 / 40.toFloat(),
                            this.context,
                            Node(if (i != quantity -1) mutableListOf(i+1) else mutableListOf(), "qwerty")
                    )
            )
        }
        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        1000 / 40.toFloat(),
                        this.context,
                        Node(mutableListOf())
                )
        )

        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        1000 / 40.toFloat(),
                        this.context,
                        Node(mutableListOf())
                )
        )

        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        1000 / 40.toFloat(),
                        this.context,
                        Node(mutableListOf())
                )
        )
        nodes[1].node.childNodeID.addAll(mutableListOf(4, 5))
        nodes[2].node.childNodeID.add(6)
        for (i in 0 until nodes.size-1){
            nodes[i].node.childNodeID.forEach {
                lines.add(
                        Line(
                                nodes[i],
                                nodes[it],
                                this.context
                        )
                )
            }
        }
        nodes.forEach {
            this.addView(it)
        }

        lines.forEach {
            this.addView(it)
        }
        Log.d("Test", nodes.size.toString() + "\n" + lines.size.toString())
    }
    fun setNodesAndLines(mutableList: MutableList<NodeView>){
        nodes = mutableList
        lines.clear()
        this.removeAllViews()
        for (i in 0 until nodes.size-1){
            nodes[i].node.childNodeID.forEach {
                lines.add(
                        Line(
                                nodes[i],
                                nodes[it],
                                this.context
                        )
                )
            }
        }
        nodes.forEach {
            Log.d("Test", "Цвет: " + it.solidColor.toString())
            addView(it)
        }

        lines.forEach {
            addView(it)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        for (i in 0 until count){
            val view = getChildAt(i)
            view.layout(l, t, r, b)
        }
    }

}