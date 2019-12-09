package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);


    }

    public void uploadImage(View view){

        Intent intent = new Intent(getApplicationContext(), AddImagesActivity.class);
        startActivity(intent);

    }

    public void outfitRecOnClick(View view){
        setContentView(R.layout.outfit_recommender);
    }
}
