package com.sh.zsh.code.jpush_sdk;

import android.app.Application;
import android.content.Context;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by zhush on 2017/2/7.
 * E-mail zhush@jerei.com
 * PS
 */
public class JpushHelper {
    /**
     * 初始化
     * @param application
     */
    public static void initJpush(Application application){

        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(application);     		// 初始化 JPush
    }

    /**
     * 设置别名
     * @param context
     * @param alias
     */
    public  static void setAlias(Context context,String alias) {
        JPushInterface.setAliasAndTags(context, alias, null, null);
    }

}
