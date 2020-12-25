package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.waiterside.Bean.ItemBean;
import com.example.waiterside.DAO.CategoryDAO;
import com.example.waiterside.DAO.ItemDAO;

public class ItemActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder alertDialog;
    Spinner category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent=getIntent();
        int tableId = intent.getIntExtra("restrauntId", 0);

        Log.e("Table","table id in Item DAO"+tableId);

        int catid=intent.getIntExtra("categoryid",0);
        category=findViewById(R.id.categorylist);
        CategoryDAO categoryDAO=new CategoryDAO();
        listView=findViewById(R.id.listviewitems);
        categoryDAO.loaddata(ItemActivity.this,category, listView,tableId);
        ItemDAO itemDAO=new ItemDAO();
        itemDAO.loaddata1(ItemActivity.this,listView,tableId);

        final int  tableid=intent.getIntExtra("tableid",0);

    }

}