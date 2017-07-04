package com.kwave.android.firebasebbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kwave.android.firebasebbs.Util.PermissionControl;

public class MainActivity extends AppCompatActivity implements PermissionControl.CallBack{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionControl.checkVersion(this);           // 퍼미션 실시
     }

    public void startBbs(View view){
     Intent intent = new Intent(this, ListActivity.class);
     startActivity(intent);
   }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionControl.onResult(this,requestCode,grantResults);
    }

    @Override
    public void init() {
        // 초기화 처리
        Intent intent = new Intent(this, NaviActivity.class);
        startActivity(intent);

        finish();
    }
}

