package com.tplink.appstore;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tplink.appstore.mvp.view.activity.HomeActivity;

public class SplashActivity extends AppCompatActivity {

//    @BindView(R.id.enter_button)
    private Button btn_go;


    private String[] PERMISSION_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private final int REQUEST_CODE_STORAGE = 1;
    private SharedPreferences sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        ButterKnife.bind(this);
        btn_go = (Button) findViewById(R.id.enter_button);

        sp = getSharedPreferences("appStore", Context.MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst",true);
        if (!isFirst) {
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyStoragePermission();
                sp.edit().putBoolean("isFirst",false).commit();

            }
        });


    }


    private void verifyStoragePermission(){
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PermissionChecker.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,PERMISSION_STORAGE,REQUEST_CODE_STORAGE);
        } else {
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PermissionChecker.PERMISSION_GRANTED) {
            Toast.makeText(this,"授权SD卡权限成功",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"授权SD卡权限失败，可能会影响应用的使用",Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }
}
