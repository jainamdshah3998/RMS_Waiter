package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.Constants.constants;
import com.example.waiterside.DAO.TableDAO;

public class TableActivity extends AppCompatActivity {

    GridView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        listView = findViewById(R.id.tablegridview);
        TableDAO tableDAO=new TableDAO();
        tableDAO.loaddata(this,listView);
        SharedPreferences sharedPreferences;
        sharedPreferences=getSharedPreferences("RMS",MODE_PRIVATE);

        Log.e("mobile",sharedPreferences.getString("waitormobilenumer","")+"shared pref");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    RestaurantTableBean restaurantTableBean = (RestaurantTableBean) parent.getItemAtPosition(position);
                Intent intent=new Intent(TableActivity.this,OrderActivity.class);
                Log.e("Table","table id in table activity"+restaurantTableBean.getTableId());
                intent.putExtra("restrauntId",restaurantTableBean.getTableId());
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.item_logout_menu:
                constants.logout(TableActivity.this);
                break;
        }

        return true;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_addorder, menu);
        return true;

    }

}