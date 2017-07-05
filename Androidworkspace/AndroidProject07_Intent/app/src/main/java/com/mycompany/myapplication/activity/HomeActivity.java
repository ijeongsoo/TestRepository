package com.mycompany.myapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.ReviewItem;
import com.mycompany.myapplication.util.RealPathUtil;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int permissionCall = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        int permissionREX = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionWEX = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionCall != PackageManager.PERMISSION_GRANTED || permissionREX != PackageManager.PERMISSION_GRANTED || permissionWEX != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "권한을 얻음", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "권한을 얻지 못함", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void handleBtnUIActivity(View v) {
        Intent intent = new Intent(this, UIActivity.class);
        startActivity(intent);
    }

    public void handleBtnWebBrowser(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }


    public void handleBtnDialActivity(View v) {
        int permissionCall = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (permissionCall == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9895-5986"));
            startActivity(intent);
        }

    }


    public void handleBtnMapActivity(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.515889, 127.07275?z=16"));
        startActivity(intent);
    }

    public void handleBtnDataSend(View v) {
        Intent intent = new Intent(this, DataReceiveActivity.class);
        intent.putExtra("key1", 10);
        intent.putExtra("key2", "Android");
        ReviewItem review = new ReviewItem();
        review.setTitle("오늘은 화요일");
        intent.putExtra("key3", review);
        startActivity(intent);
    }

    public void handleBtnReturnValue(View v) {
        Intent intent = new Intent(this, ReturnValueActivity.class);
        intent.putExtra("x", 10);
        intent.putExtra("y", 20);
        startActivityForResult(intent, 1);
    }

    public void handleBtnFileSelect(View v) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "이미지 선택"), 2);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result", 0);
                Log.i(TAG, "전달된 결과 : " + result);
            } else {
                Log.i(TAG, "전달결과 없음");
            }

        } else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                String path = RealPathUtil.getRealPath(this, uri);
                Log.i(TAG, path);
            }
        }

    }

}
