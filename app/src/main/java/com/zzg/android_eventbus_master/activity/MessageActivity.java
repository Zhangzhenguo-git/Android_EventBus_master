package com.zzg.android_eventbus_master.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zzg.android_eventbus_master.R;
import com.zzg.android_eventbus_master.bean.MessageEvent;
import com.zzg.android_eventbus_master.bean.SomeOtherEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends AppCompatActivity {


    @BindView(R.id.btn_first_event)
    Button btnFirstEvent;
    @BindView(R.id.tv_ShowTitle1)
    TextView tvShowTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        myClick();
    }

    private void myClick() {
        btnFirstEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("准备订阅者咯", 1));
            }
        });
    }


}
