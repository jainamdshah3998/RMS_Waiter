package com.example.waiterside.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waiterside.Adapter.TableAdapter;
import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.Constants.constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class TableDAO {


    public void loaddata(final Context context, final GridView listView) {
        String URL = constants.URL + "restaurantTable/show";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                RestaurantTableBean[] restaurantTableBeans = gson.fromJson(response, RestaurantTableBean[].class);



                TableAdapter tableAdapter = new TableAdapter(context, restaurantTableBeans);
                listView.setAdapter(tableAdapter);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Login", "Hello" + error.getMessage());

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }
}
