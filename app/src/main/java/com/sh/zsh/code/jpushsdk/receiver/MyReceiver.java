package com.sh.zsh.code.jpushsdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.sh.zsh.code.jpush_sdk.JpushReceiver;
import com.sh.zsh.code.jpushsdk.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

/**
 * 自定义接收器
 * 
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 */
public class MyReceiver extends JpushReceiver {
	private static final String TAG = "JPush";
	private Context context;
	@Override
	public void onReceive(Context context, Intent intent) {
		this.context =context;
		super.onReceive(context,intent);
	}

	/**
	 * 用户点击了消息
	 * @param message
     */
	@Override
	public void clickMessage(String message) {
		Log.d(TAG, message);
		//打开自定义的Activity
		Intent i = new Intent(context, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
		context.startActivity(i);
	}

	/**
	 * 接到了消息
	 * @param message
	 * @param messageId
     */
	@Override
	public void pushMessage(String message, int messageId) {
		//发送广播 通知页面
		Log.d(TAG, message);
		Intent intent = new Intent();
		intent.setAction(MainActivity.ACTION);
		intent.putExtra(MainActivity.MESSAGE_KEY,message);
		context.sendOrderedBroadcast(intent,null);
	}

}
