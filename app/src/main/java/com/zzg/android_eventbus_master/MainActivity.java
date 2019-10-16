package com.zzg.android_eventbus_master;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zzg.android_eventbus_master.activity.MessageActivity;
import com.zzg.android_eventbus_master.bean.MessageEvent;
import com.zzg.android_eventbus_master.bean.SomeOtherEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_StartEB)
    Button btStartEB;
    @BindView(R.id.tv_ShowTitle)
    TextView tvShowTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myClick();
    }

    private void myClick() {
        btStartEB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    /**
     * 这里的Event对象根据自己的需求定义Bean
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, event.getName(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 这里的Event对象根据自己的需求定义Bean
     * @param event
     */
    @Subscribe
    public void handleSomethingElse(SomeOtherEvent event) {
//        doSomethingWith(event);
    }

//    注册
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("执行onStart","注册");
        EventBus.getDefault().register(this);

    }

//    //注销，针对于不同逻辑处理进行注销
//    @Override
//    protected void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }
    //注销，针对于不同逻辑处理进行注销
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("执行onDestroy","注销");
        EventBus.getDefault().unregister(this);
    }
}
