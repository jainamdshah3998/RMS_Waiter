package com.example.waiterside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waiterside.Constants.Validation;
import com.example.waiterside.Constants.constants;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText edt_txt_mobile,edt_txt_password;
    Button button_login;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    String mobilenumber="";
    String password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("RMS", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        edt_txt_mobile=findViewById(R.id.edttxt_login_mobile);
        edt_txt_password=findViewById(R.id.edttxt_login_password);

        button_login=findViewById(R.id.btn_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag=true;

                mobilenumber=edt_txt_mobile.getText().toString();
                password=edt_txt_password.getText().toString();
               // Toast.makeText(getApplicationContext(),mobilenumber+" "+password,Toast.LENGTH_LONG).show();
                Log.e("Login",password);
                if(Validation.isEmpty(mobilenumber))
                {
                    edt_txt_mobile.setError("Enter Mobile Number");
                    flag=false;
                }
                if (Validation.isEmpty(password))
                {
                    edt_txt_password.setError("Enter Password");
                    flag=false;
                }
                if(flag)
                {


                    String URL= constants.URL+"user/login";

                    StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e("Login", response + "HELLO");
                            if (response.equals("success")) {
                                editor.putString("waitormobilenumer", mobilenumber);
                                editor.commit();


                                Intent intent = new Intent(LoginActivity.this, TableActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Invalid username or password or role", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Login", "ERROR" + error.toString()+error.getMessage());
                            Toast.makeText(getApplicationContext(),"in error login",Toast.LENGTH_LONG).show();
                            error.printStackTrace();

                        }
                    }

                )

                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("mobileNumber", mobilenumber);
                            params.put("password", password);
                           // Toast.makeText(getApplicationContext(),""+params,Toast.LENGTH_LONG).show();
                            return params;
                        }
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<String, String>();
                           // headers.put("Content-Type", "application/json; charset=utf-8");
                            return headers;
                        }

                    };
                    RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
                    requestQueue.add(stringRequest);

                }
            }
        });


    }
}