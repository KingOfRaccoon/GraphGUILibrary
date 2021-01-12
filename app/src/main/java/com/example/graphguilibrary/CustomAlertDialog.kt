package com.example.graphguilibrary

import android.app.AlertDialog
import android.graphics.PointF
import android.os.Build
import android.util.Log
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.lang.Float.min

// класс для вызова AlertDialog
class CustomAlertDialog {
    @RequiresApi(Build.VERSION_CODES.N)
    fun createAlertDialog(activity: MainActivity, nodeView: NodeView): AlertDialog.Builder? {
        val view = activity.layoutInflater.inflate(R.layout.main_fragment, null)
        return AlertDialog.Builder(activity)
                .setTitle("Добавление узла")
                .setView(view)
                .setPositiveButton("Добавить") { dialog, which ->
                    Log.d("Test",view.findViewById<EditText>(R.id.name).text.toString())
                    Log.d("Test",view.findViewById<EditText>(R.id.desc).text.toString())
                    val model = nodeView.parent as Model
                    model.addNodeView(nodeView, NodeView(
                            PointF((0..1000).random().toFloat(), (0..1000).random().toFloat()),
                            kotlin.math.min(activity.display!!.width, activity.display!!.height) / 20.toFloat(),
                            activity,
                            Node(mutableListOf(), mutableListOf(view.findViewById<EditText>(R.id.name).text.toString(), view.findViewById<EditText>(R.id.desc).text.toString())),
                        activity))
                }
    }
}