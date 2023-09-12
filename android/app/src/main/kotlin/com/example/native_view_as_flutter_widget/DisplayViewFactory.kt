package com.example.native_view_as_flutter_widget

import android.content.Context
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class DisplayViewFactory(private val messenger: BinaryMessenger): PlatformViewFactory(StandardMessageCodec.INSTANCE){

    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        return DisplayViewWidget(context, viewId, messenger)
    }
}
