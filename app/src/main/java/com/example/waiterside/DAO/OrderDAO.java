package com.example.waiterside.DAO;

import android.content.Context;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waiterside.Adapter.OrderAdapter;
import com.example.waiterside.Adapter.TableAdapter;
import com.example.waiterside.Bean.ItemBean;
import com.example.waiterside.Bean.OrderedItemsBean;
import com.example.waiterside.Bean.RestaurantTableBean;
import com.example.waiterside.Constants.constants;
import com.example.waiterside.OrderActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderDAO  {



    public void loaddata(final Context context, final GridView listView, final int tableId) {


        final int[] id = new int[1];
        String URL = constants.URL + "orderedItems/order/" + tableId;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Login", "hello in order" + response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gSon = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
                OrderedItemsBean[] orderedItemsBeans = gSon.fromJson(response, OrderedItemsBean[].class);
                OrderAdapter orderAdapter = new OrderAdapter(context, orderedItemsBeans,listView);
                listView.setAdapter(orderAdapter);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Login", "ERROR " + error.toString() + error.getMessage());
            }
        }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void deletedata(int itemId, final Context context)
    {

        String url=constants.URL+"orderedItems/delete/"+itemId;
        StringRequest stringRequest=new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Order","delete");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context.getApplicationContext(),"Item Removed",Toast.LENGTH_LONG).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public  void updateOrder(final OrderedItemsBean orderedItemsBean, final Context context)
    {
        Log.e("Update","Update"+orderedItemsBean.getQuantity());

        String url=constants.URL+"orderedItems/update/quantity";
        StringRequest stringRequest=new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Update","Update onResponsse"+orderedItemsBean.getQuantity());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Update","Update"+error.toString());
                Log.e("Update get message","Update"+error.getMessage());
//                Log.e("Update","Update"+error.toString());
                error.printStackTrace();


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Log.e("Update","Update in map");

                Map<String,String> params = new HashMap<>();
                params.put("orderedItemsId",orderedItemsBean.getOrderedItemsId()+"");
                params.put("quantity",orderedItemsBean.getQuantity()+"");
                Log.e("Update","Update in map"+params.get("orderedItemsId"));
                Log.e("Update","Update in qunatity"+params.get("quantity"));
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }

}
