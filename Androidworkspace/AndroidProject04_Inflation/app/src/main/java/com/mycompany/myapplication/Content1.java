package com.mycompany.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ijeongsu on 2017. 6. 28..
 */

public class Content1 extends LinearLayout{
    private LinearLayout itemContainer;

    public Content1(Context context) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.content1, this);

        itemContainer=(LinearLayout) findViewById(R.id.itemContainer);

    }

    public void addItem(Item1 item1){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.content1_item, null);
        ImageView photo =(ImageView)view.findViewById(R.id.photho);
        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView star = (ImageView)view.findViewById(R.id.star);
        TextView content = (TextView) view.findViewById(R.id.content);

        photo.setImageResource(item1.getPhoto());
        title.setText(item1.getTitle());
        star.setImageResource(item1.getStar());
        content.setText(item1.getContent());
        itemContainer.addView(view);
    }
}
