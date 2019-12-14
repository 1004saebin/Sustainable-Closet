package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class IndRatingActivity extends AppCompatActivity {

    private GridView grid;
    private List<String> listOfImagesPath;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ind_img);

        imageView = findViewById(R.id.im1);

        imageView.setImageResource(R.drawable.image12);



    }
}
