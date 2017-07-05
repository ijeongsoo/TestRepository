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
import com.mycompany.myapplication.content.ReviewList;
import com.mycompany.myapplication.dto.ReviewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewListFragment extends Fragment {
    private static final String TAG= ReviewList.class.getSimpleName();

    private ListView listView;
    private List<ReviewItem> list = new ArrayList<>();
    private ItemAdapter itemAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listView= (ListView) inflater.inflate(R.layout.fragment_review_list, container, false);
        itemAdapter=new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=10; i++){
            ReviewItem item = new ReviewItem();
            item.setPhoto(getResources().getIdentifier("member"+i, "drawable", getContext().getPackageName()));
            item.setTitle("ListView와 Adapter");
            item.setStar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
            item.setContent("aaaaaaaaaaaaaaaljalajljaljaljalajlalajlajlajlajlajlajlajalja");
            addItem(item);
        }
    }

    private AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ReviewItem review = (ReviewItem)itemAdapter.getItem(i);
            Log.i(TAG, review.getTitle());
            Log.i(TAG, review.getContent());
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
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(ReviewItem item){
        list.remove(item);
        itemAdapter.notifyDataSetInvalidated();
    }
}
