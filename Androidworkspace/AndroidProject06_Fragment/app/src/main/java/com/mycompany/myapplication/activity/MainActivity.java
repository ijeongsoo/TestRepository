package com.mycompany.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.fragment.FoodListFragment;
import com.mycompany.myapplication.fragment.ImgListFragment;
import com.mycompany.myapplication.fragment.ReviewListFragment;

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
        ReviewListFragment rf=new ReviewListFragment();


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, rf);
        ft.commit();


    }

    public void handleBtn2(View v){
        FoodListFragment ff=new FoodListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, ff);
        ft.commit();
    }


    public void handleBtn3(View v){
        ImgListFragment ilf=new ImgListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, ilf);
        ft.commit();
    }
}
