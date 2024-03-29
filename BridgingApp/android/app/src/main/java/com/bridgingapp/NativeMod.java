package com.bridgingapp;

import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

public class NativeMod extends ReactContextBaseJavaModule {
    private static final String MODULE_NAME = "Toast";
    private static final String LENGTH_SHORT_KEY = "LENGTH_SHORT";
    private static final String LENGTH_LONG_KEY = "LENGTH_LONG";

    public NativeMod(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(LENGTH_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(LENGTH_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    void navigateToExample() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, MapActivity.class);
        context.startActivity(intent);
    }
}
