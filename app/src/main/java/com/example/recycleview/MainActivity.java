package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.TrendingArticleAdapter;
import com.example.recycleview.model.Article;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTrendingArticles;
    private TrendingArticleAdapter adapter;
    private ArrayList<Article> articleList;
    private TextView chipTrump;
    private CardView cardFeatured;
    private ImageView ivSearch, ivNotification;
    private LinearLayout navHome, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTrendingArticles = findViewById(R.id.recyclerViewTrendingArticles);
        chipTrump = findViewById(R.id.chipTrump);
        cardFeatured = findViewById(R.id.cardFeatured);
        ivSearch = findViewById(R.id.ivSearch);
        ivNotification = findViewById(R.id.ivNotification);
        
        navHome = findViewById(R.id.navHome);
        navProfile = findViewById(R.id.navProfile);

        recyclerViewTrendingArticles.setLayoutManager(new LinearLayoutManager(this));
        
        articleList = new ArrayList<>();
        articleList.add(new Article(
                R.drawable.city_new,
                "BBC News",
                "1 hour ago",
                "People spend night on roofs and in trees after Ukraine dam breach",
                "1.2k",
                "9",
                "34",
                "120 sources",
                1
        ));
        articleList.add(new Article(
                R.drawable.trum_new,
                "BBC News",
                "1 hour ago",
                "People spend night on roofs and in trees after Ukraine dam breach",
                "1.2k",
                "9",
                "34",
                "120 sources",
                2
        ));
        articleList.add(new Article(
                R.drawable.ukraina_new,
                "BBC News",
                "2 hours ago",
                "Volodymyr Zelenskyy visits flooded regions following devastating dam collapse",
                "980",
                "4",
                "19",
                "85 sources",
                3
        ));

        adapter = new TrendingArticleAdapter(this, articleList, article -> {
            Intent intent = new Intent(MainActivity.this, HashtagActivity.class);
            intent.putExtra("HASHTAG", "#Trump");
            startActivity(intent);
        });

        recyclerViewTrendingArticles.setAdapter(adapter);

        navHome.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        navProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });

        chipTrump.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HashtagActivity.class);
            intent.putExtra("HASHTAG", "#Trump");
            startActivity(intent);
        });

        cardFeatured.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HashtagActivity.class);
            intent.putExtra("HASHTAG", "#Ukraine");
            startActivity(intent);
        });

        ivSearch.setOnClickListener(v -> 
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
        );

        ivNotification.setOnClickListener(v -> 
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()
        );
    }
}
