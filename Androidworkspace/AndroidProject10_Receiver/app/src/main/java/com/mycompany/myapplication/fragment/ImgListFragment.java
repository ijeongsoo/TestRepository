package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImgListFragment extends Fragment {
    private ListView listView;
    private List<Image> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=12; i++){
            Image img = new Image();
            img.setIno(i);
            img.setIname("img"+i);
            img.setIphoto(getResources().getIdentifier("img"+i, "drawable", getContext().getPackageName()));
            img.setIstar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
            img.setIdesc("img"+i+"입니다. ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
            addItem(img);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listView= (ListView) inflater.inflate(R.layout.fragment_img_list, container, false);
        itemAdapter= new ItemAdapter();
        listView.setAdapter(itemAdapter);

        return listView;
    }
    public class ItemAdapter extends BaseAdapter {

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
