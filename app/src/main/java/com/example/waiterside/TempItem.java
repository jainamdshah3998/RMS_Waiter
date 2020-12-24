package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;

import com.android.volley.toolbox.HttpClientStack;

public class TempItem extends AppCompatActivity {

    Spinner categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_item);
        categoryList=findViewById(R.id.spinnercategory);

    }

    public class LoadCategory extends AsyncTask<Object,Object,Object>
    {

        @Override
        protected Object doInBackground(Object... params) {

            Log.i("data","do in background");
           // HttpClient
            return null;
        }
    }
}