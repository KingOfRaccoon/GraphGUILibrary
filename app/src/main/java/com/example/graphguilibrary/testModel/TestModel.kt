//package com.example.graphguilibrary.testModel
//
//import android.content.Context
//import android.graphics.PointF
//import android.util.Log
//import android.view.ViewGroup
//import com.example.graphguilibrary.Line
//import com.example.graphguilibrary.Node
//
//class TestModel(context: Context, quantity: Int): ViewGroup(context){
//    var nodes = mutableListOf<Node>()
//    val lines = mutableListOf<Line>()
//    //    lateinit var node: Node
//    init {
//        for (i in 0 until quantity){
//            nodes.add(
//                Node(
//                    PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
//                    1000 / 40.toFloat(),
//                    this.context,
//                    if (i != quantity -1) mutableListOf(i+1) else mutableListOf()
//                )
//            )
//        }
//        nodes.add(
//                Node(
//                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
//                        1000 / 40.toFloat(),
//                        this.context,
//                        mutableListOf()
//                )
//        )
//
//        nodes.add(
//                Node(
//                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
//                        1000 / 40.toFloat(),
//                        this.context,
//                        mutableListOf()
//                )
//        )
//
//        nodes.add(
//                Node(
//                        PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
//                        1000 / 40.toFloat(),
//                        this.context,
//                        mutableListOf()
//                )
//        )
//        nodes[1].childNodeID.addAll(mutableListOf(4, 5))
//        nodes[2].childNodeID.add(6)
//        for (i in 0 until nodes.size-1){
//            nodes[i].childNodeID.forEach {
//                lines.add(
//                    Line(
//                        nodes[i],
//                        nodes[it],
//                        this.context
//                    )
//                )
//            }
//        }
//        nodes.forEach {
//            this.addView(it)
//        }
//
//        lines.forEach {
//            this.addView(it)
//        }
//        Log.d("Test", nodes.size.toString() + "\n" + lines.size.toString())
//    }
//    fun setNodesAndLines(mutableList: MutableList<Node>){
//        nodes = mutableList
//        lines.clear()
//        this.removeAllViews()
//        for (i in 0 until nodes.size-1){
//            nodes[i].childNodeID.forEach {
//                lines.add(
//                        Line(
//                                nodes[i],
//                                nodes[it],
//                                this.context
//                        )
//                )
//            }
//        }
//        nodes.forEach {
//            addView(it)
//        }
//
//        lines.forEach {
//            addView(it)
//        }
//    }
//
//    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
//        val count = childCount
//        for (i in 0 until count){
//            val view = getChildAt(i)
//            view.layout(l, t, r, b)
//        }
//    }
//
//}