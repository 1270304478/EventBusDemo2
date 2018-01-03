package com.bwei.eventbusdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.passwork)
    EditText passwork;
 //   private List<UserEvent> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
      //  mdata = new ArrayList<UserEvent>();
    }

    @OnClick(R.id.but_login)
    public void onViewClicked() {
        String name = username.getText().toString().trim();
        String pass = passwork.getText().toString().trim();
        EventBus.getDefault().postSticky(new UserEvent(name,pass));
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }


}
