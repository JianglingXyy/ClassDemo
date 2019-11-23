package com.example.classdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.classdemo.activity.ConstraintLayoutActivity;
import com.example.classdemo.activity.LifecycleActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "*********MainActivity";
    private Button btnActivityLife;
    private Button btnConstraintLayout;
    private Button btnDemo01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        btnActivityLife = findViewById(R.id.btn_lifecycle);
        btnConstraintLayout = findViewById(R.id.btn_constraintLayout);
        btnDemo01  = findViewById(R.id.btn_demo01);

        btnDemo01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: button wa clicked");
            }
        });



        btnActivityLife.setOnClickListener(this);
        btnConstraintLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_lifecycle:
                intent = new Intent(this, LifecycleActivity.class);
//                intent = new Intent("com.example.activitytest.ACTION_START");
                break;

            case R.id.btn_constraintLayout:
                intent = new Intent(this, ConstraintLayoutActivity.class);
                break;

        }

//        startActivity(intent);
//        finish();
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        String backData = data.getStringExtra("return_data");
                        Log.e(TAG, "onActivityResult: "+backData);
                    }
                }
        }
    }

    /**
     * Activity创建或者从后台重新回到前台时被调用
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    /**
     * Activity从后台重新回到前台时被调用
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    /**
     *Activity创建或者从被覆盖、后台重新回到前台时被调用
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }


    /**
     *  Activity被覆盖到下面或者锁屏时被调用
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    /**
     *退出当前Activity或者跳转到新Activity时被调用
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    /**
     *退出当前Activity时被调用,调用之后Activity就结束了
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
