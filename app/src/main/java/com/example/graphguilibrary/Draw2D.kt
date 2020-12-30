package com.example.graphguilibrary

import android.content.Context
import android.graphics.Canvas
import android.util.DisplayMetrics
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class Draw2D(context:Context, var display: DisplayMetrics, var quantity: Int): View(context) {
    lateinit var gestureDetector: GestureDetector
    init {
//        gestureDetector = GestureDetector(context, MyGestureListener())
//        val typedArray = context.obtainStyledAttributes(R.styleable.Draw2D)
//        quantity = typedArray.getInt(R.styleable.Draw2D_quantity, 0)
//        typedArray.recycle()
//
//        isHorizontalScrollBarEnabled = true
//        isVerticalScrollBarEnabled = true
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        GraphModel(quantity, display, canvas, context)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (gestureDetector.onTouchEvent(event))
            return true
        return true
    }

    inner class MyGestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            scrollBy(distanceX.toInt(), distanceY.toInt())
            return true
        }

    }

//    override fun computeHorizontalScrollRange(): Int {
//        return im
//    }
//
//    override fun computeVerticalScrollRange(): Int {
//        return super.computeVerticalScrollRange()
//    }
}