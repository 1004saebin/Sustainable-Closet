package com.example.sustainablecloset;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OutfitRecommenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_recommender);
    }

    public ArrayList<String> getOutfits(){
        ArrayList<String> ImgArr = new ArrayList<>();
        ImgArr.add("./outfit_recommend_1.jpeg");
        ImgArr.add("./outfit_recommend_2.jpeg");
        ImgArr.add("./outfit_recommend_3.jpeg");
        ImgArr.add("./outfit_recommend_4.jpeg");
        return ImgArr;
    }


}
