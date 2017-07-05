package com.mycompany.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "mainActivity";
    private LinearLayout llTop;
    private FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llTop=(LinearLayout)findViewById(R.id.llTop);
        frameLayout=(FrameLayout)findViewById(R.id.frameLayout);
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
        frameLayout.removeAllViews();
        Content1 content1= new Content1(this);
        frameLayout.addView(content1);
        for(int i=1; i<=10; i++) {
            Item1 item1 = new Item1();
            item1.setPhoto(getResources().getIdentifier("member"+i, "drawable",getPackageName()));
            item1.setTitle("반복학습이 중요"+i);
            item1.setStar(getResources().getIdentifier("star"+i, "drawable",getPackageName()));
            item1.setContent("이거 너무 쉬운거 아닙니가?"+i);
            content1.addItem(item1);
        }

    }
    public void handleBtn2(View v){

    }
    public void handleBtn3(View v){

    }
}
