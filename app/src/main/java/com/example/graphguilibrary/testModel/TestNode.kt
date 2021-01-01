package com.example.graphguilibrary.testModel

import android.content.Context
import android.graphics.PointF
import com.example.graphguilibrary.Node

class TestNode(center: PointF, radius: Float, context: Context, var childNodeID: MutableList<Int>): Node(center, radius, context) {
    constructor(
            center: PointF,
            radius: Float,
            context: Context,
            childNodeID: MutableList<Int>,
            data: Any
    ):this(center, radius, context, childNodeID){
        this.data = data
    }
}