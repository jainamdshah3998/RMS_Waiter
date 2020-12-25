package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.waiterside.Bean.CategoryBean;
import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.DAO.CategoryDAO;

public class CategoryActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent=getIntent();
        final int  tableid=intent.getIntExtra("tableid",0);

        listView=findViewById(R.id.lstview_category);
        CategoryDAO categoryDAO=new CategoryDAO();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CategoryBean categoryBean= (CategoryBean) parent.getItemAtPosition(position);
                Intent intent=new Intent(CategoryActivity.this,ItemActivity.class);
                intent.putExtra("tableid",tableid);
                intent.putExtra("categoryid",categoryBean.getCategoryId());
                startActivity(intent);

            }
        });

    }
}