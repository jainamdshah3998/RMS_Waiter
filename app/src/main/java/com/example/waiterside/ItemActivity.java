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


      /*  final ItemDAO itemDAO=new ItemDAO();
        itemDAO.loaddata(ItemActivity.this,listView,catid);*/
        final int  tableid=intent.getIntExtra("tableid",0);
      //  Log.e("Login","in item detailid"+tableid);
      /*  category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // String selecteditem=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(),selecteditem,Toast.LENGTH_LONG).show();
            }
        });
*/

/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                alertDialog = new AlertDialog.Builder(ItemActivity.this);
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //itemDAO.addneworder(tableid);


                    }
                });

                alertDialog.show();


            }
        });*/

    }
}