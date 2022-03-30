package com.example.testmodule;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniModule;

public class TestModule extends UniModule {
    private static final String TAG = "TestModule";

    @UniJSMethod(uiThread = true)
    public void testAsyncFunc(JSONObject options, UniJSCallback callback) {
        Log.e(TAG, "testAsyncFunc--"+options);
        if(callback != null) {

            JSONObject data = new JSONObject();
            data.put("code", "success");
            callback.invoke(data);
        }
    }

    //run JS thread
    @UniJSMethod (uiThread = false)
    public JSONObject testSyncFunc(){
        Log.e(TAG, "testSyncFunc--");
        JSONObject data = new JSONObject();
        data.put("code", "success");
        return data;
    }
}
