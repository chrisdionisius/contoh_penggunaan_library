package com.example.april12th;

import android.content.Intent;
import android.os.Bundle;

import com.example.bni_floating_bubble.TriggerActivity;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "flutter.native/helper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this.getFlutterEngine());
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL).setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                        if (call.method.equals("moveToFloating")) {
                            moveToFloating();
                        }
                    }
                });
    }

    public void moveToFloating() {
        Intent moveAbout = new Intent(MainActivity.this, TriggerActivity.class);
        startActivity(moveAbout);
    }
}
