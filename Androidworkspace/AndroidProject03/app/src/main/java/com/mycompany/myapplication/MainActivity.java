package com.mycompany.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llTop;
    private LinearLayout c1;
    private LinearLayout c2;
    private LinearLayout c3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llTop=(LinearLayout)findViewById(R.id.llTop);
        c1=(LinearLayout)findViewById(R.id.c1);
        c2=(LinearLayout)findViewById(R.id.c2);
        c3=(LinearLayout)findViewById(R.id.c3);
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
        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
    }
    public void handleBtn2(View v){
        c2.setVisibility(View.VISIBLE);
        c1.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
    }
    public void handleBtn3(View v){
        c3.setVisibility(View.VISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c1.setVisibility(View.INVISIBLE);
    }
}
