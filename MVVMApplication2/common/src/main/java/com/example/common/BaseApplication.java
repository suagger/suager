package com.example.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {

    private boolean isModuleARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();

        if(isModuleARouter){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
