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

public class SignUpActivity extends AppCompatActivity {
    private TextView textName;
    private TextView textMail;
    private TextView textPassword;
    private TextView textPhone;
    private Button butSign;
    private Button butLog;

    String nameV = textName.getText().toString();
    String emailV = textMail.getText().toString();
    String passwordV = textPassword.getText().toString();
    String phoneV = textPhone.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textName = findViewById(R.id.signupNameTxt);
        textMail = findViewById(R.id.signUpMailTxt);
        textPassword = findViewById(R.id.sigUpPaswdTxt);
        textPhone = findViewById(R.id.sigUpPhoneTxt);
        butSign = findViewById(R.id.sigUpbuttonSign);
        butLog = findViewById(R.id.signUpbuttonLogin);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        butSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textName.getText().toString().isEmpty()) {
                    textName.setError("Required");
                } else if (textMail.getText().toString().isEmpty()) {
                    textMail.setError("Required");
                } else if (textPassword.getText().toString().isEmpty()) {
                    textPassword.setError("Required");
                } else if (textPhone.getText().toString().isEmpty()) {
                    textPhone.setError("Required");
                } else {
                    createUser();
                }
            }
        });
    }

    private void createUser() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.CREATE_USER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("User created")) {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.d("tag", response);
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
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