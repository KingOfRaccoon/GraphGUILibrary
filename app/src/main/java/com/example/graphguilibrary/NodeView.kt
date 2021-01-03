package com.example.graphguilibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.Display
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.lang.Math.abs
import java.text.AttributedCharacterIterator
import java.text.FieldPosition
import kotlin.math.sqrt

class NodeView(var center: PointF, var radius: Float, context: Context, var node: Node)
    : androidx.appcompat.widget.AppCompatButton(context){
    init {
        layoutParams = ViewGroup.LayoutParams(radius.toInt()*2, radius.toInt()*2)
        bottom = (center.y + radius).toInt()
        top = (center.y - radius).toInt()

//        Log.d("Test", this.height.toString())
//        Log.d("Test", this.top.toString())
//        Log.d("Test", this.bottom.toString())
//        setMeasuredDimension(radius.toInt()*2, radius.toInt()*2)
//        invalidate()

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint(Color.BLUE)
//        Log.d("Test",canvas.height.toString() + " Canvas")
        canvas.drawCircle(center.x, center.y, radius, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
//        Log.d("Test",event.x.toString())
        Log.d("Test", this.height.toString())
        if (event.action == MotionEvent.ACTION_DOWN)
            Log.d("Test", node.toString())
        return true
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        setMeasuredDimension(radius.toInt()*2, radius.toInt()*2)
//    }
    fun isContains(event: MotionEvent):Boolean{
        Log.d("Test", this.height.toString())
        Log.d("Test", this.top.toString())
        Log.d("Test", this.bottom.toString())
        val dx = this.center.x - event.x
        val dy = this.center.y - event.y

        val dist = sqrt(dx*dx + dy*dy)

        return dist <= radius
    }
}