package com.example.corsair_v.mytab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UserSetting extends AppCompatActivity {

    private TextView logout;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_tab_5_setting);
//
//        logout = (TextView) findViewById(R.id.re_Logout);
//**
// *返回到原来碎片
// **
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_5_setting);

        logout = (TextView) findViewById(R.id.re_Logout);


//        //返回到原来碎片
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
    //退出到登录界面
    public void re_Logout(View v) {
        Intent intent = new Intent(UserSetting.this, FirstLogin.class);
        startActivity(intent);
    }

}

