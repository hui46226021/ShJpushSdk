package com.sh.zsh.code.jpushsdk;

import android.app.Application;

import com.sh.zsh.code.jpush_sdk.JpushHelper;

/**
 * Created by zhush on 2017/2/7.
 * E-mail zhush@jerei.com
 * PS
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        JpushHelper.initJpush(this);
    }
}
