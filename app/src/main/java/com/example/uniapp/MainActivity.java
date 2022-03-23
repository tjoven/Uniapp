package com.example.uniapp;

import androidx.appcompat.app.AppCompatActivity;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.feature.sdk.DCSDKInitConfig;
import io.dcloud.feature.sdk.DCUniMPSDK;
import io.dcloud.feature.sdk.Interface.IDCUniMPPreInitCallback;
import io.dcloud.feature.sdk.Interface.IMenuButtonClickCallBack;
import io.dcloud.feature.sdk.Interface.IUniMP;
import io.dcloud.feature.sdk.MenuActionSheetItem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MenuActionSheetItem item = new MenuActionSheetItem("关于", "gy");
        List<MenuActionSheetItem> sheetItems = new ArrayList<>();
        sheetItems.add(item);
        DCSDKInitConfig config = new DCSDKInitConfig.Builder()
                .setCapsule(true)
                .setMenuDefFontSize("16px")
                .setMenuDefFontColor("#ff00ff")
                .setMenuDefFontWeight("normal")
                .setMenuActionSheetItems(sheetItems)
                .build();

        DCUniMPSDK.getInstance().initialize(this, config, new IDCUniMPPreInitCallback() {
            @Override
            public void onInitFinished(boolean b) {
                Log.d(TAG,"onInitFinished");
            }
        });

        DCUniMPSDK.getInstance().setDefMenuButtonClickCallBack(new IMenuButtonClickCallBack() {
            @Override
            public void onClick(String appid, String id) {
                switch (id) {
                    case "gy":{
                        Log.d(TAG,appid+"用户点击了关于");
                    }
                }
            }
        });


    }


    public void test(View view) {
        try {
            IUniMP uniMP = DCUniMPSDK.getInstance().openUniMP(MainActivity.this,"__UNI__E0CBE50");

//            IUniMP uniMP = DCUniMPSDK.getInstance().openUniMP(MainActivity.this,"__UNI__4138A06");
            //            mUniMPCaches.put(uniMP.getAppid(), uniMP);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}