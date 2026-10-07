package com.example.recycleview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.ArticleAdapter;
import com.example.recycleview.model.Article;

import java.util.ArrayList;

public class HashtagActivity extends AppCompatActivity {

    private RecyclerView recyclerViewArticles;
    private ArticleAdapter adapter;
    private ArrayList<Article> articleList;
    private ImageView ivBack;
    private TextView tvHashtagTitle, tvArticleCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtag);

        ivBack = findViewById(R.id.ivBack);
        tvHashtagTitle = findViewById(R.id.tvHashtagTitle);
        tvArticleCount = findViewById(R.id.tvArticleCount);
        recyclerViewArticles = findViewById(R.id.recyclerViewArticles);

        String hashtag = getIntent().getStringExtra("HASHTAG");
        if (hashtag != null && !hashtag.isEmpty()) {
            tvHashtagTitle.setText(hashtag);
        }

        recyclerViewArticles.setLayoutManager(new LinearLayoutManager(this));

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
                "1 hour ago",
                "People spend night on roofs and in trees after Ukraine dam breach",
                "1.2k",
                "9",
                "34",
                "120 sources",
                3
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
                4
        ));
        articleList.add(new Article(
                R.drawable.ukraina_new,
                "BBC News",
                "1 hour ago",
                "People spend night on roofs and in trees after Ukraine dam breach",
                "1.2k",
                "9",
                "34",
                "120 sources",
                5
        ));

        tvArticleCount.setText(articleList.size() + " articles");

        adapter = new ArticleAdapter(this, articleList, article -> 
            Toast.makeText(this, "Clicked: " + article.getTitle(), Toast.LENGTH_SHORT).show()
        );

        recyclerViewArticles.setAdapter(adapter);

        ivBack.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(HashtagActivity.this, MainActivity.class);
            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP | android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        getOnBackPressedDispatcher().addCallback(this, new androidx.activity.OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                android.content.Intent intent = new android.content.Intent(HashtagActivity.this, MainActivity.class);
                intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP | android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
