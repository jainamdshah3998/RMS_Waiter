package com.example.waiterside.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waiterside.Bean.ItemBean;
import com.example.waiterside.DAO.ItemDAO;
import com.example.waiterside.ItemActivity;
import com.example.waiterside.OrderActivity;
import com.example.waiterside.R;

public class ItemAdapter extends BaseAdapter {
    Context context;
    ItemBean[] itemBeans;
    AlertDialog.Builder alertDialog;
    int tableId;

    public ItemAdapter(Context context, ItemBean[] itemBeans,int tableId) {
        this.context = context;
        this.itemBeans = itemBeans;
        this.tableId=tableId;
    }


    @Override
    public int getCount() {
        return itemBeans.length;
    }

    @Override
    public Object getItem(int position) {
        return itemBeans[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(R.layout.view_items, parent, false);
        TextView textView = convertView.findViewById(R.id.item_textview1);
        TextView textView1 = convertView.findViewById(R.id.item_textview2);
        TextView textView2 = convertView.findViewById(R.id.item_textview3);
        TextView textView3 = convertView.findViewById(R.id.item_textview4);
        textView.setText(itemBeans[position].getItemId()+"");
        textView1.setText(itemBeans[position].getItemDescription()+"");
        textView2.setText(itemBeans[position].getItemName()+"");
        textView3.setText(itemBeans[position].getItemPrice()+"");

        Button addFoodItem=convertView.findViewById(R.id.itembutton);
        addFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+itemBeans[position].getItemId(), Toast.LENGTH_SHORT).show();
                final ItemDAO itemDAO=new ItemDAO();

//                Add item quantiy dialog box


                alertDialog=new AlertDialog.Builder(context);
                View view1 = LayoutInflater.from(context).inflate(R.layout.layout_qty_additem, null, false);
                alertDialog.setView(view1);
                final EditText qty = view1.findViewById(R.id.add_qty);
                final EditText instruction = view1.findViewById(R.id.add_instruction);


                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setPositiveButton("Add Item", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemDAO.addfooditem(context,itemBeans[position].getItemId(),qty.getText().toString(),instruction.getText().toString(),tableId);
                        Intent intent=new Intent(context, OrderActivity.class);
                        intent.putExtra("restrauntId",tableId);
                        context.startActivity(intent);
                        ((Activity)context).finish();
                    }
                });
                alertDialog.show();

            }
        });
        return convertView;
    }
}
