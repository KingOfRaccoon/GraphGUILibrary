package com.example.graphguilibrary

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.Log
import android.view.View
import android.widget.Button

open class Node(var center: PointF, var radius: Float, context: Context):View(context), View.OnClickListener {
    var data :Any? = null
    constructor(
            center: PointF,
            radius: Float,
            context: Context,
            data : Any
    ): this(center, radius, context){
        this.data = data
        this.setOnClickListener {
            Log.d("Test", toString())
        }
    }
    public override fun onDraw(canvas: Canvas){
        canvas.drawCircle(center.x, center.y, radius, Paint(Color.CYAN))
    }
    override fun onClick(v: View?) {
        Log.d("Test", TestData.list[0].toString())
    }


    override fun toString(): String {
        if (data == null)
            return "Пустой узел"
        else
            return data.toString()
    }
}