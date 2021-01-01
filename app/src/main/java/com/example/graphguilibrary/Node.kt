package com.example.graphguilibrary

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.Log
import android.view.View
import android.widget.Button

open class Node(var childNodeID: MutableList<Int>){
    var data :Any? = null
    constructor(
            childNodeID: MutableList<Int>,
            data : Any
    ): this(childNodeID){
        this.data = data
    }

    override fun toString(): String {
        if (data == null)
            return "Пустой узел"
        else
            return data.toString()
    }
}