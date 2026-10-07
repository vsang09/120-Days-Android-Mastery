package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.adapter.HomeFeedAdapter;
import com.example.recycleview.model.Article;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHomeFeed;
    private HomeFeedAdapter adapter;
    private ArrayList<Article> articleList;
    private ImageView ivSearch, ivNotification, ivFilter;
    private TextView chipSport, chipTech, chipLifestyle, chipAi, chipFitness;
    private LinearLayout navHome, navExplore, navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewHomeFeed = findViewById(R.id.recyclerViewHomeFeed);
        ivSearch = findViewById(R.id.ivSearch);
        ivNotification = findViewById(R.id.ivNotification);
        ivFilter = findViewById(R.id.ivFilter);
        
        chipSport = findViewById(R.id.chipSport);
        chipTech = findViewById(R.id.chipTech);
        chipLifestyle = findViewById(R.id.chipLifestyle);
        chipAi = findViewById(R.id.chipAi);
        chipFitness = findViewById(R.id.chipFitness);

        navHome = findViewById(R.id.navHome);
        navExplore = findViewById(R.id.navExplore);
        navProfile = findViewById(R.id.navProfile);

        recyclerViewHomeFeed.setLayoutManager(new LinearLayoutManager(this));

        articleList = new ArrayList<>();
        articleList.add(new Article(
                R.drawable.tinnong_title,
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
                R.drawable.ukraina_title,
                "BBC News",
                "1 hour ago",
                "Volodymyr Zelenskyy visits flooded regions following devastating dam collapse",
                "1.2k",
                "9",
                "34",
                "120 sources",
                2
        ));
        articleList.add(new Article(
                R.drawable.city_title,
                "BBC News",
                "1 hour ago",
                "Volodymyr Zelenskyy visits flooded regions following devastating dam collapse",
                "1.2k",
                "9",
                "34",
                "120 sources",
                2
        ));

        adapter = new HomeFeedAdapter(this, articleList, article -> {
            Intent intent = new Intent(HomeActivity.this, HashtagActivity.class);
            intent.putExtra("HASHTAG", "#Ukraine");
            startActivity(intent);
        });

        recyclerViewHomeFeed.setAdapter(adapter);

        navExplore.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        navProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });

        View.OnClickListener chipListener = v -> {
            TextView tv = (TextView) v;
            Toast.makeText(this, "Selected category: " + tv.getText(), Toast.LENGTH_SHORT).show();
        };

        chipSport.setOnClickListener(chipListener);
        chipTech.setOnClickListener(chipListener);
        chipLifestyle.setOnClickListener(chipListener);
        chipAi.setOnClickListener(chipListener);
        chipFitness.setOnClickListener(chipListener);
        ivFilter.setOnClickListener(v -> Toast.makeText(this, "Filter clicked", Toast.LENGTH_SHORT).show());

        ivSearch.setOnClickListener(v -> Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show());
        ivNotification.setOnClickListener(v -> Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show());
    }
}
