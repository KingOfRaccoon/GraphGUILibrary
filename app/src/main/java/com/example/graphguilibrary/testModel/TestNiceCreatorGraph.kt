package com.example.graphguilibrary.testModel

import android.graphics.PointF
import com.example.graphguilibrary.Model
import com.example.graphguilibrary.Node
import com.example.graphguilibrary.NodeView

class TestNiceCreatorGraph(var testModel: Model) {
    fun createNiceGraph(mutableListNodes: MutableList<NodeView>, width: Float, height: Float){
        mutableListNodes.forEachIndexed { index, node ->
            if (index == 0)
                node.center = PointF(width / (2 * (index + 1)), node.radius + (height / mutableListNodes.size) * index)
            node.node.childNodeID.forEachIndexed { i, it ->
                mutableListNodes[it].center = PointF(((node.center.x*2 / (node.node.childNodeID.size+1)) * (i+1)), (height / mutableListNodes.size) * (index + 1))
            }
        }
        testModel.setNodesAndLines(mutableListNodes)
    }
}