package com.example.native_view_as_flutter_widget

import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.platform.PlatformView

class DisplayViewWidget internal constructor(context: Context, id: Int, messenger: BinaryMessenger) : PlatformView, MethodCallHandler{

    private var view: View = LayoutInflater.from(context).inflate(R.layout.activity_my_native_view, null)
    private val methodChannel: MethodChannel = MethodChannel(messenger, "plugins/display_view_widget_$id")


    override fun getView(): View {
        return view
    }

    init {
        methodChannel.setMethodCallHandler(this)
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method){
            "draggable" -> draggable(call, result)
            else -> result.notImplemented()
        }
    }

    private fun draggable(call: MethodCall, result: MethodChannel.Result) {
        val isDraggable: Boolean = call.arguments as Boolean

        result.success(null)

    }

    override fun dispose() {

    }


}