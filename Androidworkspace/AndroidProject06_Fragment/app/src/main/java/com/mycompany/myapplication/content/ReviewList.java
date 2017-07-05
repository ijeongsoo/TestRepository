package com.mycompany.myapplication.content;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.mycompany.myapplication.dto.ReviewItem;
import com.mycompany.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ijeongsu on 2017. 6. 28..
 */

public class ReviewList extends LinearLayout{
    private static final String TAG= ReviewList.class.getSimpleName();

    private ListView listView;
    private List<ReviewItem> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    public ReviewList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView)inflater.inflate(R.layout.review_list, null);
        itemAdapter=new ItemAdapter();
        listView.setAdapter(itemAdapter);
        addView(listView);

        listView.setOnItemClickListener(itemClickListener);

    }

    private AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ReviewItem review = (ReviewItem)itemAdapter.getItem(i);
            Log.i(TAG, review.getTitle());
            Log.i(TAG, review.getContent());
        }
    };

    class ItemAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                view= (LinearLayout)inflater.inflate(R.layout.review_item, null);
            }

            ImageView photo =(ImageView) view.findViewById(R.id.photho);
            TextView title=(TextView) view.findViewById(R.id.title);
            ImageView star=(ImageView) view.findViewById(R.id.star);
            TextView content=(TextView) view.findViewById(R.id.content);

            ReviewItem item = list.get(i);
            photo.setImageResource(item.getPhoto());
            title.setText(item.getTitle());
            star.setImageResource(item.getStar());
            content.setText(item.getContent());

            return view;
        }
    }

    public void addItem(ReviewItem item){
        list.add(item)
;       itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(ReviewItem item){
        list.remove(item);
        itemAdapter.notifyDataSetInvalidated();
    }
}
