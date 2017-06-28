package com.mycompany.myapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private ImageView imgTitle;
    private Button btnImg1;
    private Button btnImg2;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgTitle=(ImageView) findViewById(R.id.imgTitle);
        btnImg1=(Button) findViewById(R.id.btnImg1);
        btnImg2=(Button) findViewById(R.id.btnImg2);
        rb1=(RadioButton) findViewById(R.id.rb1);
        rb2=(RadioButton) findViewById(R.id.rb2);

        btnImg1.setOnClickListener(handleBtnImg);
        btnImg2.setOnClickListener(handleBtnImg);
        rb1.setOnClickListener(handleBtnImg);
        rb2.setOnClickListener(handleBtnImg);
    }

    private View.OnClickListener handleBtnImg = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == btnImg1 || view==rb1) {
                imgTitle.setImageResource(R.drawable.green);
            }else if(view == btnImg2 ||view==rb2){
                imgTitle.setImageResource(R.drawable.red);
            }
        }
    };


    public void handleBtnImg3(View v){
        imgTitle.setImageResource(R.drawable.loading);
    }

    public void handleRb3(View v){
        imgTitle.setImageResource(R.drawable.loading);
    }




}
