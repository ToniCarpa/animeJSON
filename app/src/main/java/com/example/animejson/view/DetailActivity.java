package com.example.animejson.view;

import static java.util.Arrays.asList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animejson.R;
import com.example.animejson.adapter.AdapaterVideo;
import com.example.animejson.adapter.AdapterRowVideo;
import com.example.animejson.model.Anime;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView textname;
    private TextView textori;
    private TextView textdesc;
    private TextView texttype;
    private TextView textpg;
    private TextView textyear;
    private TextView textdemo;
    private ImageView imageView;

    List<Anime> animes;
    String[] animevideos;

    AdapterRowVideo adapterRowVideo;
    RecyclerView recyclerView;


    String name, originalName, description, genre, type, demography, rating, favorite, image, image2, episode, url, idanime;
    int year;
    Boolean active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        animes = intent.getParcelableArrayListExtra("animes");
        int position = intent.getIntExtra("position", 0);
        animevideos = animes.get(position).getAnimevideos();

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("name")) {
            name = getIntent().getStringExtra("name");
            description = getIntent().getStringExtra("description");
            originalName = getIntent().getStringExtra("originalName");
            genre = getIntent().getStringExtra("genre");
            year = Integer.parseInt(getIntent().getStringExtra("year"));
            image = getIntent().getStringExtra("image");
            image2 = getIntent().getStringExtra("image2");
            type = getIntent().getStringExtra("type");
            demography = getIntent().getStringExtra("demography");
            rating = getIntent().getStringExtra("rating");
            favorite = getIntent().getStringExtra("favorite");
            active = Boolean.valueOf(getIntent().getStringExtra("active"));
            animevideos = getIntent().getStringArrayListExtra("animevideos").toArray(new String[0]);
        } else {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        textname.setText(name);
        textori.setText(originalName);
        textdesc.setText(description);
        texttype.setText(type);
        textpg.setText(rating);
        textyear.setText(year);
        textdemo.setText(demography);

        Picasso.get().load(image)
                .fit()
                .centerCrop()
                .into(imageView);


        adapterRowVideo = new AdapterRowVideo(this, animevideos);
        recyclerView.setAdapter(null);
    }
}