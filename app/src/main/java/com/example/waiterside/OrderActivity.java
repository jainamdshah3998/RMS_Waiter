package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waiterside.Constants.constants;
import com.example.waiterside.DAO.OrderDAO;

public class OrderActivity extends AppCompatActivity {
    GridView listView;
    int tableId=1;
    Button addItem;
    TextView head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        tableId = intent.getIntExtra("restrauntId", 0);
        head=findViewById(R.id.tablename);
        head.setText("Table No : "+tableId);
        listView = findViewById(R.id.orderitem);
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.loaddata(OrderActivity.this, listView, tableId);
        addItem=findViewById(R.id.addfooditem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(OrderActivity.this,ItemActivity.class);
                Log.e("Table","table id in Order activity"+tableId);

                intent.putExtra("restrauntId",tableId);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case  R.id.item_logout_menu:
                constants.logout(OrderActivity.this);
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