package com.bridgingapp;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;



public class BridgeModule extends ReactContextBaseJavaModule {

    public BridgeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }


    @Override
    public String getName() {
        return "BridgeModule";
    }

    @ReactMethod
    public static void testMethod(){
        Log.d("Bridge","Testing Bridge");

    }

    @ReactMethod
    public static void testCallBackMethod(Callback callback){
        Log.d("Bridge","Testing Bridge");
        String token= "Prem";
        callback.invoke(token);
    }

    @ReactMethod
    void navigateToExample() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, MapActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
