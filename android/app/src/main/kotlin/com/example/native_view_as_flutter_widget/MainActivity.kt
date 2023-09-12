package com.example.native_view_as_flutter_widget

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        flutterEngine.platformViewsController.registry.registerViewFactory(
            "plugins/display_view_widget",
            DisplayViewFactory(flutterEngine.dartExecutor.binaryMessenger)
        )

    }

}
