package com.yxl.husky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.husky.activity.NormalVideoActivity;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button mBtnNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        }, 201);

        init();
    }

    private void init() {
        mBtnNormal = findViewById(R.id.btn_normal_play);
        mBtnNormal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_normal_play:
                intent = new Intent(this, NormalVideoActivity.class);
                break;
        }


        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}