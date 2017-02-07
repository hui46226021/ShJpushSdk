package com.sh.zsh.code.jpushsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sh.zsh.code.jpush_sdk.JpushHelper;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.alias);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.message);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JpushHelper.setAlias(MainActivity.this,"1234567");
            }
        });


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION);
        registerReceiver(broadcastReceiver,intentFilter);//注册下载广播
    }

    public static String ACTION="com.jg.message";
    public static String MESSAGE_KEY="message";
    BroadcastReceiver broadcastReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(MESSAGE_KEY);
            textView.setText(message);
        }
    };
}
