package com.mycompany.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleBtnMessageDialog(View v){
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setIcon(R.mipmap.ic_launcher)
            .setTitle("제목")
            .setMessage("알려줄 메시지")
            .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.i(TAG, "닫기 버튼");
                }
            })
            .setNegativeButton("취소", null)
            .setNeutralButton("확인", null)
            .create();

        dialog.show();
    }

    public void handleBtnListDialog(View v){
        final String [] menus = {"메뉴1", "메뉴2", "메뉴3"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("선택하세요")
                .setItems(menus, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selectedMenu = menus[i];
                        Log.i(TAG, selectedMenu);
                    }
                })
                .create();
        dialog.show();
    }

    public void handleBtnSingleChoiceDialog(View v){
        final String [] menus = {"메뉴1", "메뉴2", "메뉴3"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("선택하세요")
                .setSingleChoiceItems(menus,1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selectedMenu = menus[i];
                        Log.i(TAG, selectedMenu);
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();
    }



    public void handleBtnMultiChoiceDialog(View v){
        final String [] menus = {"메뉴1", "메뉴2", "메뉴3"};
        final boolean[] selected={false, true, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("선택하세요")
                .setMultiChoiceItems(menus,selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                       selected[i] = b;
                    }
                })
                .setPositiveButton("취소", null)
                .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int j=0; j<selected.length; j++){
                            if(selected[j]){
                                String menu =menus[j];
                                Log.i(TAG, menu+" ");
                            }
                        }
                    }
                })
                .create();
        dialog.show();
    }


    public void handleBtnStickProgressDialog(final View v){
        final ProgressDialog dialog= new ProgressDialog(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("통신상태");
        dialog.setMessage("다운로드 중입니다");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(1024);
        dialog.setProgress(1000);
        dialog.show();
        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i=0; i<=1024; i++){
                    final int value =i;
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setProgress(value);
                            dialog.setSecondaryProgress(value);
                        }
                    };

                    v.post(runnable);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public void handleBtnCircleProgressDialog(final View v){
        final ProgressDialog dialog= new ProgressDialog(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("통신상태");
        dialog.setMessage("다운로드 중입니다");
        dialog.show();

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runnable runnable = new Runnable(){
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                };

                v.post(runnable);
            }
        };

        thread.start();
    }

    public void handleBtnCustomDialog(View v){
        CustomDialog dialog = new CustomDialog();
        dialog.show(getSupportFragmentManager(), null);
    }
}
