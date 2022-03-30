package com.example.uniapp;

import android.app.Application;
import com.example.testmodule.TestModule;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            WXSDKEngine.registerModule("TestModule", TestModule.class);
//            WXSDKEngine.registerComponent("myText", TestText.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
