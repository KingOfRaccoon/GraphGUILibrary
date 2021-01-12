package com.example.graphguilibrary

import android.content.Context
import android.graphics.*
import android.os.Build
import android.os.VibrationAttributes
import android.os.Vibrator
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import androidx.annotation.RequiresApi

// класс для отображения узла
class NodeView(var center: PointF, var radius: Float, context: Context, var node: Node, activity: MainActivity)
    : androidx.appcompat.widget.AppCompatButton(context){

    val gestureDetector = GestureDetector(context, object : SimpleOnGestureListener() {

        @RequiresApi(Build.VERSION_CODES.N)
        override fun onLongPress(e: MotionEvent) { // длинный ТЫК
            Log.e("Test", "Longpress detected")
            CustomAlertDialog().createAlertDialog(activity, this@NodeView)!!.create().show()
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean { // одиночный ТЫК
            Log.d("Test", this@NodeView.node.toString())
            return true
        }

    })

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)
        return true
    }
}