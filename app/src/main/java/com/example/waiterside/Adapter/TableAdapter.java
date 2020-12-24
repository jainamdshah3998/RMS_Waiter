package com.example.waiterside.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.R;

import java.util.ArrayList;


public class TableAdapter extends BaseAdapter {

    Context context;
    RestaurantTableBean[] restaurantTableBeans;

    public TableAdapter(Context context, RestaurantTableBean[] restaurantTableBeanarray) {
        this.context = context;
        restaurantTableBeans=restaurantTableBeanarray;

    }

    @Override
    public int getCount() {
        return restaurantTableBeans.length;
    }

    @Override
    public Object getItem(int position) {
        return restaurantTableBeans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //if (context==null)
        convertView = inflater.inflate(R.layout.custom_table, parent, false);
        TextView textview1=convertView.findViewById(R.id.textView1);
      //  TextView textView = convertView.findViewById(R.id.textView2);
       // TextView textView1 = convertView.findViewById(R.id.textView3);
       // textView.setText(restaurantTableBeans[position].getTableId()+"");
        textview1.setText("Table "+restaurantTableBeans[position].getTableId());
        ImageView image=convertView.findViewById(R.id.imageView1);
        image.setImageResource(R.drawable.tables);
        return convertView;
    }
}
