package com.example.waiterside.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waiterside.Bean.OrderedItemsBean;
import com.example.waiterside.DAO.OrderDAO;
import com.example.waiterside.OrderActivity;
import com.example.waiterside.R;

public class OrderAdapter extends BaseAdapter {
    Context context;
    OrderedItemsBean[] orderedItemsBean;
    GridView listview;

    public OrderAdapter(Context context, OrderedItemsBean[] orderedItemsBean,GridView gridView) {
        this.context = context;
        this.orderedItemsBean = orderedItemsBean;
        listview=gridView;
    }

    @Override
    public int getCount() {
        return orderedItemsBean.length;
    }

    @Override
    public Object getItem(int position) {
        return orderedItemsBean[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_order, parent, false);
       // TextView textView = convertView.findViewById(R.id.itemname);
        TextView textView1 = convertView.findViewById(R.id.itemname);
        TextView textView2 = convertView.findViewById(R.id.price);
        final TextView textView3 = convertView.findViewById(R.id.quantity);
        Button minus=convertView.findViewById(R.id.minusbtn);
        Button plus=convertView.findViewById(R.id.plusbtn);
        ImageView del=convertView.findViewById(R.id.removebtn);
        final OrderDAO orderDAO=new OrderDAO();

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int q= Integer.parseInt(textView3.getText().toString());
                if(q==1)
                {
                    Toast.makeText(parent.getContext(), "Delete Item From List", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    q-=1;
                    textView3.setText(Integer.toString(q));

                }
                orderedItemsBean[position].setQuantity(q);
                Toast.makeText(parent.getContext(),"Minus Button Clicked",Toast.LENGTH_LONG).show();
                orderDAO.updateOrder(orderedItemsBean[position],context);
                Intent intent=new Intent(context, OrderActivity.class);
                intent.putExtra("restrauntId",orderedItemsBean[position].getOrder().getCustomersitting().getRestauranttable().getTableId());
                context.startActivity(intent);
                ((Activity)context).finish();

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int q= Integer.parseInt(textView3.getText().toString());
                    q+=1;
                    textView3.setText(Integer.toString(q));
                    orderedItemsBean[position].setQuantity(q);
                Toast.makeText(parent.getContext(),"Plus Button CLicked",Toast.LENGTH_LONG).show();
                orderDAO.updateOrder(orderedItemsBean[position],context);
                Intent intent=new Intent(context, OrderActivity.class);
                intent.putExtra("restrauntId",orderedItemsBean[position].getOrder().getCustomersitting().getRestauranttable().getTableId());
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(),"Remove Button Clicked",Toast.LENGTH_LONG).show();
                orderDAO.deletedata(orderedItemsBean[position].getOrderedItemsId(),context);
                Intent intent=new Intent(context, OrderActivity.class);
                intent.putExtra("restrauntId",orderedItemsBean[position].getOrder().getCustomersitting().getRestauranttable().getTableId());
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });
      //  textView.setText(orderedItemsBean[position].getInstruction()+"");
        textView1.setText(orderedItemsBean[position].getItem().getItemName()+"");
        textView2.setText(orderedItemsBean[position].getItem().getItemPrice()+"");
        textView3.setText(orderedItemsBean[position].getQuantity()+"");

        return  convertView;
    }
}
