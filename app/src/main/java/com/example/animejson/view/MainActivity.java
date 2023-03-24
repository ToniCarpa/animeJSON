package com.example.animejson.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.animejson.R;
import com.example.animejson.model.Anime;
import com.example.animejson.model.User;
import com.example.animejson.utils.Constants;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txtpass;
    private TextView txtmail;
    private Button butLog;
    private Button butSig;

    //ArrayList<User> userlist = new ArrayList<>();

    private String pass;
    private String mail;

    private String urlJSON = Constants.LOGIN_USER_URL + mail + "&password=" + pass;
    public static String EMAIL_USER = "com.example.animeJSON.EMAIL_USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtpass = findViewById(R.id.loginPassTxt);
        txtmail = findViewById(R.id.loginEmailTxt);
        butLog = findViewById(R.id.loginButLog);
        butSig = findViewById(R.id.loginButSig);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtpass.getText().toString().isEmpty()) {
                    txtpass.setError("Required");
                } else if (txtmail.getText().toString().isEmpty()) {
                    txtmail.setError("Required");
                } else {
                    pass = txtpass.getText().toString();
                    mail = txtmail.getText().toString();

                    loginUser();
                }
            }
        });
        butSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("tag", "Loged");
                        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                        intent.putExtra(EMAIL_USER, mail);

                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Sign Up, please", error.getMessage());
                        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(intent);
                    }
                }
        );
        queue.add(objectRequest);
    }

}