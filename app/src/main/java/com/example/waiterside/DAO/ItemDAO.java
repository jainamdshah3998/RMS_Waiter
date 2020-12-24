package com.example.waiterside.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waiterside.Adapter.CategoryAdapter;
import com.example.waiterside.Adapter.ItemAdapter;
import com.example.waiterside.Adapter.OrderAdapter;
import com.example.waiterside.Bean.CategoryBean;
import com.example.waiterside.Bean.ItemBean;
import com.example.waiterside.Bean.OrderedItemsBean;
import com.example.waiterside.Constants.constants;
import com.example.waiterside.ItemActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class ItemDAO {


    public void loaddata(final ItemActivity itemActivity, final ListView listView, int catid,final int tableId) {

        String URL = constants.URL + "item/category/"+catid;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                //RestaurantTableBean[] restaurantTableBeans = gson.fromJson(response, RestaurantTableBean[].class);
                ItemBean[] itemBeans=gson.fromJson(response,ItemBean[].class);
                ItemAdapter itemAdapter=new ItemAdapter(itemActivity,itemBeans,tableId);
                listView.setAdapter(itemAdapter);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Login", "Hello" + error.getMessage());

            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(itemActivity);
        requestQueue.add(stringRequest);

    }

    public void loaddata1(final Context context , final ListView listView, final int tableId) {


        String URL = constants.URL + "item/show/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ItemBean[] itemBeans=gson.fromJson(response,ItemBean[].class);
                ItemAdapter itemAdapter=new ItemAdapter(context,itemBeans,tableId);
                listView.setAdapter(itemAdapter);
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

    public  void  addfooditem(Context context, final int itemId, final String qty, final String instruction, final int tableId)
    {
        String url=constants.URL+"orderedItems/items/add";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();

                params.put("itemId",itemId+"");
                params.put("quantity",qty);
                params.put("instruction",instruction);
                params.put("tableId",tableId+"");
                Log.e("Item",itemId+"");
                Log.e("Item",qty+"");
                Log.e("Item",instruction+"");
                Log.e("Item",tableId+"");

                return params;

            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);



    }

}
