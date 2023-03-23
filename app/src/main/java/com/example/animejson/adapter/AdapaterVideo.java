package com.example.animejson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animejson.R;
import com.example.animejson.model.Anime;

import java.util.List;

public class AdapaterVideo extends RecyclerView.Adapter<AdapaterVideo.VideoViewHolder> {
    private Context context;
    private List<Anime> animes;

    public AdapaterVideo(Context context, List<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.textView.setText(animes.get(position).getAnimevideos()[position]);
        holder.webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        WebView webView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rowVideoTitTxt);
            webView = itemView.findViewById(R.id.webView2);
        }
    }
}
