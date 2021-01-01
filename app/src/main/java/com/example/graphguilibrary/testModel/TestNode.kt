package com.example.graphguilibrary.testModel

import android.content.Context
import android.graphics.PointF
import android.util.Log
import android.view.View
import com.example.graphguilibrary.Node

class TestNode(center: PointF, radius: Float, context: Context, childNodeID: MutableList<Int>): Node(center, radius, context, childNodeID) {
    constructor(
            center: PointF,
            radius: Float,
            context: Context,
            childNodeID: MutableList<Int>,
            data: Any
    ):this(center, radius, context, childNodeID){
        this.data = data
    }

    override fun toString(): String {
        return data.toString()
    }

    override fun onClick(v: View?) {
        Log.d("Test", toString())
    }
}