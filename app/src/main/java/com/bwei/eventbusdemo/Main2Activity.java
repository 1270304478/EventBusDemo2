package com.bwei.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends Activity {
    @BindView(R.id.but_shuju)
    Button butShuju;
    @BindView(R.id.text_view)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        textView.setText("账号多少呢！");
    }
    @OnClick(R.id.but_shuju)
    public void onViewClicked() {
        if(!EventBus.getDefault().isRegistered(Main2Activity.this)){
            EventBus.getDefault().register(Main2Activity.this);
        }else{
            Toast.makeText(Main2Activity.this, "请勿重复注册事件", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(Main2Activity.this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onMoonEvent(UserEvent userevent){
        textView.setText("账号："+userevent.getUsername()+"密码："+userevent.getPasswork());
    }
}
