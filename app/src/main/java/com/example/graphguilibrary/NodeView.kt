package com.example.graphguilibrary

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.MotionEvent
import android.view.View

class NodeView(var center: PointF, var radius: Float, context: Context, var node: Node): View(context){
    init {

    }
//    override fun onDraw(canvas: Canvas) {
//        canvas.drawCircle(center.x, center.y, radius, Paint())
//    }
//
    override fun dispatchDraw(canvas: Canvas) {
        val paint = Paint()
        canvas.drawCircle(center.x, center.y, radius, paint)
//        canvas.drawOval(RectF(center.x- 2*radius, center.y+radius, center.x+radius, center.y-radius),paint)
//        canvas.drawBitmap(bitmap, center.x, center.y, null)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN)
            Log.d("Test", node.toString())
        return true
    }
}