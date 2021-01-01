package com.example.graphguilibrary.testModel

import android.graphics.PointF
import com.example.graphguilibrary.Model
import com.example.graphguilibrary.Node

class TestNiceCreatorGraph(var testModel: Model) {
    fun createNiceGraph(mutableListNodes: MutableList<Node>, width: Float, height: Float){
        mutableListNodes.forEachIndexed { index, node ->
            if (index == 0)
                node.center = PointF(width / (2 * (index + 1)), node.radius + (height / mutableListNodes.size) * index)
            node.childNodeID.forEachIndexed { i, it ->
                mutableListNodes[it].center = PointF(((node.center.x*2 / (node.childNodeID.size+1)) * (i+1)), (height / mutableListNodes.size) * (index + 1))
            }
        }
        testModel.setNodesAndLines(mutableListNodes)
    }
}