import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

typedef DisplayViewCallBack = void Function(DisplayViewController controller);

class DisplayNativeView extends StatefulWidget {
  const DisplayNativeView({super.key, this.displayViewCallBack});

  final DisplayViewCallBack? displayViewCallBack;

  @override
  State<StatefulWidget> createState() => DisplayNativeViewState();
}

class DisplayNativeViewState extends State<DisplayNativeView> {
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
        viewType: "plugins/display_view_widget",
        onPlatformViewCreated: _onPlatformCreated,
      );
    }
    return const Text("Error while connecting to Android View");
  }

  void _onPlatformCreated(int id) {
    if (widget.displayViewCallBack == null) {
      return;
    }
    widget.displayViewCallBack!(DisplayViewController._(id));
  }
}

class DisplayViewController {
  DisplayViewController._(int id)
      : _channel = MethodChannel("plugins/display_view_widget_$id");

  final MethodChannel _channel;

  Future<Future<List?>> draggable(bool value) async {
    return _channel.invokeListMethod("draggable", value);
  }
}
