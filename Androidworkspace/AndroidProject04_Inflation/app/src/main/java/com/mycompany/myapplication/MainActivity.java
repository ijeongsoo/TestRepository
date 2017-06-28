package com.mycompany.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llTop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llTop=(LinearLayout)findViewById(R.id.llTop);

    }

    public void handleRb1(View v){
        llTop.setBackgroundResource(R.drawable.green);
    }
    public void handleRb2(View v){
        llTop.setBackgroundResource(R.drawable.red);
    }
    public void handleRb3(View v){
        llTop.setBackgroundResource(R.drawable.loading);
    }

    public void handleBtn1(View v){

    }
    public void handleBtn2(View v){

    }
    public void handleBtn3(View v){

    }
}
