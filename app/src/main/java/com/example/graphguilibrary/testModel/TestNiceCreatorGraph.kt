package com.example.graphguilibrary.testModel

import android.graphics.PointF

class TestNiceCreatorGraph(var testModel: TestModel) {
    fun createNiceGraph(mutableListNodes: MutableList<TestNode>, width: Float, height: Float){
        mutableListNodes.forEachIndexed { index, testNode ->
            if (index == 0)
                testNode.center = PointF(width / (2 * (index + 1)), testNode.radius + (height / mutableListNodes.size) * index)
            testNode.childNodeID.forEachIndexed { i, it ->
                mutableListNodes[it].center = PointF(((testNode.center.x*2 / (testNode.childNodeID.size+1)) * (i+1)), (height / mutableListNodes.size) * (index + 1))
            }
        }
        testModel.setNodesAndLines(mutableListNodes)
    }
}