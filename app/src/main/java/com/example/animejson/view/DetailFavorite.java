package com.example.animejson.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.animejson.R;
import com.example.animejson.adapter.ViewPagerFav;
import com.example.animejson.model.Anime;

import java.util.List;

public class DetailFavorite extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private List<Anime> animeList ;
    private ViewPagerFav viewPagerAdapter;
    private Anime anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favorite);

        viewPager2 = findViewById(R.id.viewPagerFav);
        Intent intent = getIntent();
        animeList = intent.getParcelableArrayListExtra("animeList");
        int position = intent.getIntExtra("position", 0);
        viewPager2.setCurrentItem(position, true);

        viewPagerAdapter = new ViewPagerFav(this, animeList);
        viewPager2.setAdapter(viewPagerAdapter);
    }
}