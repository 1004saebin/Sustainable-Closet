package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class OutfitRecommender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_recommender);
    }

    public void previousView(View view){

        Intent intent = new Intent(getApplicationContext(), RecommenderPrev.class);
        startActivity(intent);

    }


    public void nextView(View view){

        Intent intent = new Intent(getApplicationContext(), Recommender1.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_image_capture, menu);
        getMenuInflater().inflate(R.menu.addtitlebar, menu);
        return true;
    }

    public void goToLandingPage(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);

    }
    public void goToUpload(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), AddImagesActivity.class);
        startActivity(intent);

    }
    public void goToRate(MenuItem menuItem){


        Intent intent = new Intent(getApplicationContext(), EcoFriendliness.class);
        startActivity(intent);

    }
}
