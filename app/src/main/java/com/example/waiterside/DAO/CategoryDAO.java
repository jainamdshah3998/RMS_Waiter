package com.example.waiterside.DAO;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waiterside.Adapter.CategoryAdapter;
import com.example.waiterside.Adapter.OrderAdapter;
import com.example.waiterside.Adapter.TableAdapter;
import com.example.waiterside.Bean.CategoryBean;
import com.example.waiterside.Bean.OrderedItemsBean;
import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.CategoryActivity;
import com.example.waiterside.Constants.constants;
import com.example.waiterside.ItemActivity;
import com.example.waiterside.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class CategoryDAO  {

Spinner category;
    public void loaddata(final ItemActivity categoryActivity, final Spinner listView, final ListView itemslist,final int tableId) {

        String URL = constants.URL + "category/show";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                final CategoryBean [] categoryBeans=gson.fromJson(response,CategoryBean[].class);
                ArrayList<String> category1 =new ArrayList<>();
                category1.add("All Categories");

                for(int i= 0;i<categoryBeans.length;i++)
                {
                    category1.add(categoryBeans[i].getCategoryName());
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(categoryActivity, R.layout.support_simple_spinner_dropdown_item,category1);
                arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                listView.setAdapter(arrayAdapter);

                listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                   @Override
                   public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                       if(i!=0)
                       {
                           int id=categoryBeans[i-1].getCategoryId();
                           ItemDAO itemDAO=new ItemDAO();
                           itemDAO.loaddata(categoryActivity,itemslist,id,tableId);
                       }
                       else
                       {
                           ItemDAO itemDAO=new ItemDAO();
                           itemDAO.loaddata1(categoryActivity,itemslist,tableId);

                       }

                   }

                   @Override
                   public void onNothingSelected(AdapterView<?> adapterView) {

                   }
               });
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Login", "Hello" + error.getMessage());

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(categoryActivity);
        requestQueue.add(stringRequest);

    }

}
