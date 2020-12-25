package com.example.waiterside.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.waiterside.Bean.CategoryBean;
import com.example.waiterside.R;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    CategoryBean[] categoryBeans;

    public CategoryAdapter(Context context, CategoryBean[] categoryBeans) {
        this.context = context;
        this.categoryBeans = categoryBeans;
    }
    @Override
    public int getCount() {
        return categoryBeans.length;
    }

    @Override
    public Object getItem(int position) {
        return categoryBeans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.view_category, parent, false);
        TextView textView = convertView.findViewById(R.id.view_category_textView);
        TextView textView1 = convertView.findViewById(R.id.view_category_textView1);
        textView.setText(categoryBeans[position].getCategoryId()+"");
        textView1.setText(categoryBeans[position].getCategoryName()+"");
        return convertView;
    }
}
