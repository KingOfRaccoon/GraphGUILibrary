package com.example.graphguilibrary

import android.content.Context
import android.graphics.PointF
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.lang.Integer.min

// класс для отрисовки графа
class Model(context: Context):ViewGroup(context){
    var quantity = 1
    var nodes = mutableListOf<NodeView>()
    val lines = mutableListOf<Line>()
    val radius = Math.min(context.display!!.width, context.display!!.height) / 20.toFloat()
    constructor(context: Context, attributeSet: AttributeSet): this(context){
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Model,0, 0)
        try {
            quantity = typedArray.getInt(R.styleable.Model_quantity, 1)
            update()
            Log.e("Test", quantity.toString())
        }catch (e: Exception){
            Log.e("Test", e.message.toString())
        }finally {
            typedArray.recycle()
        }
    }
    init {
        update()
    }
    fun update(){
        this.removeAllViews()
        nodes.clear()
        lines.clear()
        for (i in 0 until quantity){
            nodes.add(
                    NodeView(
                            PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                            radius,
                            this.context,
                            Node(if (i != quantity - 1) mutableListOf(i + 1) else mutableListOf(), "qwerty")
                    )
            )
        }
        setNodesAndLines(nodes)
    }
    fun addNodeView(parentNodeView: NodeView, nodeView: NodeView){ // функция для добавления узла
        nodes.add(nodeView)
        parentNodeView.node.childNodeID.add(nodes.size-1)
        setNodesAndLines(nodes)
    }

    fun setNodesAndLines(mutableList: MutableList<NodeView>){ // функция для переотрисовки
        nodes = mutableList
        lines.clear()
        this.removeAllViews()
        for (i in 0 until nodes.size-1){
            nodes[i].node.childNodeID.forEach {
                lines.add(
                        Line(
                                nodes[i],
                                nodes[it],
                                this.context
                        )
                )
            }
        }
        nodes.forEachIndexed { index, node ->
            if (index == 0)
                node.center = PointF((context.display!!.width / (2 * (index + 1))).toFloat(), node.radius + (height / nodes.size) * index)
            node.node.childNodeID.forEachIndexed { i, it ->
                nodes[it].center = PointF(((node.center.x*2 / (node.node.childNodeID.size+1)) * (i+1)), ((height / nodes.size) * (index + 1)).toFloat())
            }
        }
        nodes.forEach {
            addView(it,LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        }

        lines.forEach {
            addView(it)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) { // размещение на фрагменте детей
        val count = childCount
        for (index in 0 until count){
            val view = getChildAt(index)
            if (view is NodeView){
                if (index == 0)
                    view.center = PointF((width / (2 * (index + 1))).toFloat(), view.radius + (height / calculateLevels()) * index)
                view.node.childNodeID.forEachIndexed { i, it ->
                    nodes[it].center = PointF(((view.center.x * 2 / (view.node.childNodeID.size + 1)) * (i + 1)), ((height / calculateLevels()) * (if (index == 0) 1 else getLevelNodeView(view))).toFloat())
                }
                view.layout((view.center.x-view.radius).toInt(), (view.center.y - view.radius).toInt(), (view.center.x+view.radius).toInt(), (view.center.y + view.radius).toInt())
                view.invalidate()
            }
            else
                view.layout(l, t, r, b)
        }
    }

    private fun calculateLevels(count: Int = 2):Int{
        var counter = count
        nodes.forEachIndexed { index, nodeView ->
            if (getNodesWithChild(nodeView.node.childNodeID).isNotEmpty())
                counter++
        }
        return counter
    }

    private fun getNodesWithChild(mutableList: MutableList<Int>):MutableList<NodeView>{
        val mutableListNodeViews = mutableListOf<NodeView>()
        mutableList.forEach {
            val nodeView = nodes[it]
            if (nodeView.node.childNodeID.isNotEmpty())
                mutableListNodeViews.add(nodeView)
        }
        return mutableListNodeViews
    }

    private fun getLevelNodeView(nodeView: NodeView): Int {
        var level = 1
        var view = searchParent(nodeView)
        while (view != nodes.first()){
            view = searchParent(view)
            level++
        }
        level++
        return level
    }

    private fun getPosition(nodeView: NodeView): Int {
        var position = 0
        for (i in nodes.indices){
            if (nodeView == nodes[i]){
                position = i
                break
            }
        }
        return position
    }

    private fun searchParent(nodeView: NodeView): NodeView{
        return nodes.find { it.node.childNodeID.contains(getPosition(nodeView)) }!!
    }
}