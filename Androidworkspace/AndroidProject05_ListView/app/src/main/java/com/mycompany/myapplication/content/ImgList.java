package com.mycompany.myapplication.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ijeongsu on 2017. 6. 29..
 */

public class ImgList extends LinearLayout{
    private ListView listView;
    private List<Image> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    public ImgList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.img_list, null);
        itemAdapter= new ItemAdapter();
        listView.setAdapter(itemAdapter);
        addView(listView);

    }

    public class ItemAdapter extends BaseAdapter{

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
            return list.get(i).getIno();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
               view = inflater.inflate(R.layout.img_item,null);

            }

            ImageView iphoto= (ImageView)view.findViewById(R.id.iphoto);
            TextView iname= (TextView)view.findViewById(R.id.iname);
            ImageView istar=(ImageView)view.findViewById(R.id.istar);
            TextView idesc=(TextView)view.findViewById(R.id.idesc);

            Image img = list.get(i);
            iphoto.setImageResource(img.getIphoto());
            iname.setText(img.getIname());
            istar.setImageResource(img.getIstar());
            idesc.setText(img.getIdesc());

            return view;
        }
    }

    public void addItem(Image item){
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Image item){
        list.remove(item);
        itemAdapter.notifyDataSetInvalidated();
    }
}
