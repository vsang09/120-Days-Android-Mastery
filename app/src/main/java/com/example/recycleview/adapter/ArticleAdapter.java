package com.example.recycleview.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Article> articleList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Article article);
    }

    public ArticleAdapter(Context context, ArrayList<Article> articleList, OnItemClickListener listener) {
        this.context = context;
        this.articleList = articleList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.ivThumbnail.setImageResource(article.getImage());
        holder.tvSource.setText(article.getSource());
        holder.tvTime.setText(article.getTime());
        holder.tvTitle.setText(article.getTitle());
        holder.tvLikes.setText(article.getLikes());
        holder.tvDislikes.setText(article.getDislikes());
        holder.tvBookmarks.setText(article.getBookmarks());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(article);
            }
        });

        // Like click interaction
        final boolean[] isLiked = {false};
        holder.layoutLike.setOnClickListener(v -> {
            isLiked[0] = !isLiked[0];
            if (isLiked[0]) {
                holder.ivLike.setColorFilter(context.getResources().getColor(R.color.primary_orange));
                holder.tvLikes.setTextColor(context.getResources().getColor(R.color.primary_orange));
                Toast.makeText(context, "Liked article", Toast.LENGTH_SHORT).show();
            } else {
                holder.ivLike.clearColorFilter();
                holder.tvLikes.setTextColor(context.getResources().getColor(R.color.text_gray));
            }
        });

        // Bookmark click interaction
        final boolean[] isBookmarked = {false};
        holder.layoutBookmark.setOnClickListener(v -> {
            isBookmarked[0] = !isBookmarked[0];
            if (isBookmarked[0]) {
                holder.ivBookmark.setColorFilter(context.getResources().getColor(R.color.primary_orange));
                holder.tvBookmarks.setTextColor(context.getResources().getColor(R.color.primary_orange));
                Toast.makeText(context, "Bookmark saved", Toast.LENGTH_SHORT).show();
            } else {
                holder.ivBookmark.clearColorFilter();
                holder.tvBookmarks.setTextColor(context.getResources().getColor(R.color.text_gray));
            }
        });

        holder.ivMore.setOnClickListener(v -> 
            Toast.makeText(context, "More options", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSource, tvTime, tvTitle, tvLikes, tvDislikes, tvBookmarks;
        ImageView ivThumbnail, ivLike, ivBookmark, ivMore;
        LinearLayout layoutLike, layoutBookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSource = itemView.findViewById(R.id.tvSource);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            tvDislikes = itemView.findViewById(R.id.tvDislikes);
            tvBookmarks = itemView.findViewById(R.id.tvBookmarks);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            ivLike = itemView.findViewById(R.id.ivLike);
            ivBookmark = itemView.findViewById(R.id.ivBookmark);
            ivMore = itemView.findViewById(R.id.ivMore);
            layoutLike = itemView.findViewById(R.id.layoutLike);
            layoutBookmark = itemView.findViewById(R.id.layoutBookmark);
        }
    }
}
