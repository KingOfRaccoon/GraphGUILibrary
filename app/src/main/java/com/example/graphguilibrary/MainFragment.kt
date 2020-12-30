package com.example.graphguilibrary

import android.graphics.Canvas
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment(val quantity : Int): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val canvas = Canvas()

        val nodes = mutableListOf<Node>()
        val lines = mutableListOf<Line>()
        for (i in 0 until quantity){
            nodes.add(
                    Node(
                            PointF(
                                    (0..1440).random().toFloat(),
                                    (0..3000).random().toFloat()
                            ),
                            1440 / 40.toFloat(),
                            requireContext()
                    )
            )
        }

        for (i in 0 until quantity-1){
            lines.add(
                    Line(
                            nodes[i],
                            nodes[i + 1],
                            requireContext()
                    )
            )
        }
        nodes.forEach {
            it.draw(canvas)
//            requireActivity().addContentView(it, ViewGroup.LayoutParams(it.radius.toInt() * 2, it.radius.toInt() * 2))
        }
        lines.forEach {
            it.draw(canvas)
        }


        return view
    }
}