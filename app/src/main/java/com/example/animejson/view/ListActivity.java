package com.example.animejson.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.animejson.R;
import com.example.animejson.adapter.AdapterList;
import com.example.animejson.model.Anime;
import com.example.animejson.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private AdapterList adapterList;
    private RecyclerView recyclerView;
    private List<Anime> animes;
    private String urlJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL_USER);
        urlJSON = Constants.LOGIN_USER_MAIL + email;
        getAnimes();

    }

    private void getAnimes() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                urlJSON,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray animesArray = response.getJSONArray("animeList");
                            for (int i = 0; i < animesArray.length(); i++) {

                                JSONObject jsonObject = animesArray.getJSONObject(i);
                                Anime anime = new Anime();
                                if (anime.getFavorite() != null) {
                                    anime.setName(jsonObject.getString("name"));
                                    anime.setName(jsonObject.getString("originalname"));
                                    anime.setDescription(jsonObject.getString("description"));
                                    anime.setYear(jsonObject.getInt("year"));
                                    anime.setType(jsonObject.getString("type"));
                                    anime.setType(jsonObject.getString("genre"));
                                    anime.setDemography(jsonObject.getString("demography"));
                                    anime.setImage(jsonObject.getString("image"));
                                    anime.setImage2(jsonObject.getString("image2"));
                                    anime.setFavorite(jsonObject.getString("favorite"));
                                    //OPCIO 1
                                    anime.setAnimevideos(new String[]{jsonObject.getString("animevideos")});

                                    animes.add(anime);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapterList = new AdapterList(getApplicationContext(), animes);
                        recyclerView.setAdapter(adapterList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: " + error.getMessage());
                    }
                }
        );
        queue.add(jsonObjectRequest);
    }
}