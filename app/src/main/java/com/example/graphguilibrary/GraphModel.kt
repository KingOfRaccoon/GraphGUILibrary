//package com.example.graphguilibrary
//
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.PointF
//import android.util.DisplayMetrics
//
//class GraphModel(quantity: Int, var display: DisplayMetrics, var canvas: Canvas, context: Context){
//    var nodes = mutableListOf<Node>()
//    var lines = mutableListOf<Line>()
//
//    init {
//        for (i in 0 until quantity){
//            nodes.add(
//                Node(
//                    PointF(
//                        (0..display.widthPixels).random().toFloat(),
//                        (0..display.heightPixels).random().toFloat()
//                    ),
//                    display.widthPixels/40.toFloat(),
//                    context
//                )
//            )
//        }
//
//        for (i in 0 until quantity-1){
//            lines.add(
//                Line(
//                    nodes[i],
//                    nodes[i+1],
//                    canvas
//                )
//            )
//        }
//
//        nodes.forEach {
//            it.draw(canvas)
//        }
//
//        lines.forEach {
//            it.onDraw()
//        }
//    }
//
//}