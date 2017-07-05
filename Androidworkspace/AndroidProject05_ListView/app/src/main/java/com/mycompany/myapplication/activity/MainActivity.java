package com.mycompany.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.content.FoodList;
import com.mycompany.myapplication.content.ImgList;
import com.mycompany.myapplication.content.ReviewList;
import com.mycompany.myapplication.dto.FoodItem;
import com.mycompany.myapplication.dto.Image;
import com.mycompany.myapplication.dto.ReviewItem;

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
        ReviewList content1= new ReviewList(this);
        frameLayout.addView(content1);
        for(int i=0; i<=10; i++){
            ReviewItem item = new ReviewItem();
            item.setPhoto(R.drawable.member1);
            item.setTitle("ListView와 Adapter");
            item.setStar(R.drawable.star10);
            item.setContent("aaaaaaaaaaaaaaaljalajljaljaljalajlalajlajlajlajlajlajlajalja");
            content1.addItem(item);
        }

    }
    public void handleBtn2(View v){
        frameLayout.removeAllViews();
        FoodList foodList= new FoodList(this);
        frameLayout.addView(foodList);
        for(int i=1; i<=6; i++){
            FoodItem foodItem = new FoodItem();
            foodItem.setFno(i);
            foodItem.setFname("음식"+i);
            foodItem.setFphoto(getResources().getIdentifier("food"+i, "drawable", getPackageName()));
            foodItem.setFstar(getResources().getIdentifier("star"+i, "drawable", getPackageName()));
            foodItem.setFdesc("aaaaaaaaaaaaaaaljalajljaljaljalajlalajlajlajlajlajlajlajalja");
            foodList.addItem(foodItem);
        }
    }


    public void handleBtn3(View v){
        frameLayout.removeAllViews();
        ImgList imgList = new ImgList(this);
        frameLayout.addView((imgList));
        for(int i=1; i<=12; i++){
            Image img = new Image();
            img.setIno(i);
            img.setIname("img"+i);
            img.setIphoto(getResources().getIdentifier("img"+i, "drawable", getPackageName()));
            img.setIstar(getResources().getIdentifier("star"+i, "drawable", getPackageName()));
            img.setIdesc("img"+i+"입니다. ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
            imgList.addItem(img);
        }
    }
}
