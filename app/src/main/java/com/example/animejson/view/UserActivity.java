package com.example.animejson.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.animejson.R;
import com.example.animejson.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity {
    TextView txtName;
    TextView txtEmail;
    TextView txtPass;
    TextView txtPhone;
    Button butup;
    Button butdel;

    String nameV = txtName.getText().toString();
    String emailV = txtEmail.getText().toString();
    String passwordV = txtPass.getText().toString();
    String phoneV = txtPhone.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        txtName = findViewById(R.id.userNameTxt);
        txtEmail = findViewById(R.id.userMailTxt);
        txtPass = findViewById(R.id.userpswdTxt);
        txtPhone = findViewById(R.id.userPhoneTxt);
        butup = findViewById(R.id.userButUpdate);
        butdel = findViewById(R.id.userButDele);

        butup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                udpateUser();
            }
        });
        butdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delUser();
            }
        });
    }
    public void delUser() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringrequest = new StringRequest(Request.Method.POST,
                Constants.USER_UPDATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("User deleted")) {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", emailV);
                return params;
            }
        };

    }

    public void udpateUser() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.USER_UPDATE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("User updated")) {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", nameV);
                params.put("email", emailV);
                params.put("password", passwordV);
                params.put("phone", phoneV);
                return params;
            }
        };
        queue.add(stringRequest);
    }
}