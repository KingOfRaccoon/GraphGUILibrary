package com.example.graphguilibrary.testModel

import android.content.Context
import android.graphics.PointF
import android.util.Log
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.size
import com.example.graphguilibrary.Line
import com.example.graphguilibrary.Node
import com.example.graphguilibrary.TestData

class TestModel(context: Context, quantity: Int): ViewGroup(context){
    var nodes = mutableListOf<TestNode>()
    val lines = mutableListOf<Line>()
    //    lateinit var node: Node
    init {
        for (i in 0 until quantity){
            nodes.add(
                TestNode(
                    PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                    1000 / 40.toFloat(),
                    this.context,
                    if (i != quantity -1) mutableListOf(i+1) else mutableListOf()
                )
            )
        }
        nodes.add(
                TestNode(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        1000 / 40.toFloat(),
                        this.context,
                        mutableListOf()
                )
        )
        nodes[1].сhildNodeID.add(4)
        for (i in 0 until nodes.size-1){
            nodes[i].сhildNodeID.forEach {
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
    fun setNodesAndLines(mutableList: MutableList<TestNode>){
        nodes = mutableList
        lines.clear()
        this.removeAllViews()
        for (i in 0 until nodes.size-1){
            nodes[i].сhildNodeID.forEach {
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