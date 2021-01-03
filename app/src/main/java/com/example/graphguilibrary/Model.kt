package com.example.graphguilibrary

import android.content.Context
import android.graphics.PointF
import android.view.ViewGroup

class Model(context: Context, quantity: Int):ViewGroup(context){
    var nodes = mutableListOf<NodeView>()
    val lines = mutableListOf<Line>()

    init {
        for (i in 0 until quantity){
            nodes.add(
                    NodeView(
                            PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                            context.display!!.width / 20.toFloat(),
                            this.context,
                            Node(if (i != quantity - 1) mutableListOf(i + 1) else mutableListOf(), "qwerty")
                    )
            )
        }
        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        context.display!!.width / 20.toFloat(),
                        this.context,
                        Node(mutableListOf())
                )
        )

        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        context.display!!.width / 20.toFloat(),
                        this.context,
                        Node(mutableListOf())
                )
        )

        nodes.add(
                NodeView(
                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                        context.display!!.width / 20.toFloat(),
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
            this.addView(it, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        }

        lines.forEach {
            this.addView(it)
        }
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
            addView(it,LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        }

        lines.forEach {
            addView(it)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        for (index in 0 until count){
            val view = getChildAt(index)
            if (view is NodeView){
                if (index == 0)
                    view.center = PointF((width / (2 * (index + 1))).toFloat(), view.radius + (height / nodes.size) * index)
                view.node.childNodeID.forEachIndexed { i, it ->
                    nodes[it].center = PointF(((view.center.x * 2 / (view.node.childNodeID.size + 1)) * (i + 1)), ((height / nodes.size) * (index + 1)).toFloat())
                }
                view.layout((view.center.x-view.radius).toInt(), (view.center.y - view.radius).toInt(), (view.center.x+view.radius).toInt(), (view.center.y + view.radius).toInt())
                view.invalidate()
            }
            else
                view.layout(l, t, r, b)
        }
    }
}