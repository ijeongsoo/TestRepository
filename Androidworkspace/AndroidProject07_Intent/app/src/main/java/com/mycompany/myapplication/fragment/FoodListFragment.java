package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * A simple {@link Fragment} subclass.
 */
public class FoodListFragment extends Fragment {
    private static final String TAG= FoodListFragment.class.getSimpleName();

    private ListView listView;
    private List<FoodItem> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=6; i++){
            FoodItem foodItem = new FoodItem();
            foodItem.setFno(i);
            foodItem.setFname("음식"+i);
            foodItem.setFphoto(getResources().getIdentifier("food"+i, "drawable", getContext().getPackageName()));
            foodItem.setFstar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
            foodItem.setFdesc("aaaaaaaaaaaaaaaljalajljaljaljalajlalajlajlajlajlajlajlajalja");
            addItem(foodItem);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listView= (ListView) inflater.inflate(R.layout.fragment_food_list, container, false);
        itemAdapter=new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);

        return listView;
    }
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            FoodItem review = (FoodItem) itemAdapter.getItem(i);
            Log.i(TAG, review.getFname());
            Log.i(TAG, review.getFdesc());
        }
    };

    class ItemAdapter extends BaseAdapter {

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
