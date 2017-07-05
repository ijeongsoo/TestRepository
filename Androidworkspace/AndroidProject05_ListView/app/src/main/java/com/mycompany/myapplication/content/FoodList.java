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

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ijeongsu on 2017. 6. 29..
 */

public class FoodList extends LinearLayout {
    private static final String TAG= ReviewList.class.getSimpleName();

    private ListView listView;
    private List<FoodItem> list = new ArrayList<>();
    private ItemAdapter itemAdapter;


    public FoodList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView)inflater.inflate(R.layout.food_list, null);
        itemAdapter=new ItemAdapter();
        listView.setAdapter(itemAdapter);
        addView(listView);

        listView.setOnItemClickListener(itemClickListener);

    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            FoodItem review = (FoodItem) itemAdapter.getItem(i);
            Log.i(TAG, review.getFname());
            Log.i(TAG, review.getFdesc());
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
            return list.get(i).getFno();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                view= (LinearLayout)inflater.inflate(R.layout.food_item, null);
            }

            ImageView fphoto =(ImageView)view.findViewById(R.id.fphoto);
            TextView fname=(TextView)view.findViewById(R.id.fname);
            ImageView fstar=(ImageView)view.findViewById(R.id.fstar);
            TextView fdesc=(TextView)view.findViewById(R.id.fdesc);

            FoodItem foodItem = list.get(i);
            fphoto.setImageResource(foodItem.getFphoto());
            fname.setText(foodItem.getFname());
            fstar.setImageResource(foodItem.getFstar());
            fdesc.setText(foodItem.getFdesc());

            return view;
        }
    }

    public void addItem(FoodItem item){
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(FoodItem item){
        list.remove(item);
        itemAdapter.notifyDataSetInvalidated();
    }
}
