package com.example.uniapp;

import android.app.Application;

import com.example.testmodule.TestModule;
import com.taobao.weex.WXSDKEngine;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            WXSDKEngine.registerModule("TestModule", TestModule.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
