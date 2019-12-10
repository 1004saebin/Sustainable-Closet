package com.example.sustainablecloset;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OutfitRecommenderActivity extends AppCompatActivity {

    //ViewFlipper v_flipper;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfit_recommender);

        viewFlipper = findViewById(R.id.view_flipper);
        TextView textView = new TextView(this);
        textView.setText("Dynamically added TextView");
        textView.setGravity(Gravity.CENTER);

        viewFlipper.addView(textView);



//        int images[] = {R.drawable.outfit_recommend_1, R.drawable.outfit_recommend_2, R.drawable.outfit_recommend_3, R.drawable.outfit_recommend_4};
//
//        v_flipper = findViewById(R.id.v_flipper);
//
//        for (int i = 0; i < images.length; i++){
//            flipperImages(images[i]);
//        }
    }

    public void previousView(View v){
        viewFlipper.showPrevious();
    }

    public void nextView(View v){
        viewFlipper.showNext();
    }

//    public void flipperImages(int image){
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//
//        v_flipper.addView(imageView);
//        v_flipper.setFlipInterval(4000);
//        v_flipper.setAutoStart(true);
//
//        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
//        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
//    }

    //From Chidi
//    public ArrayList<String> getOutfits(){
//        ArrayList<String> ImgArr = new ArrayList<>();
//        ImgArr.add("./outfit_recommend_1.jpeg");
//        ImgArr.add("./outfit_recommend_2.jpeg");
//        ImgArr.add("./outfit_recommend_3.jpeg");
//        ImgArr.add("./outfit_recommend_4.jpeg");
//        return ImgArr;
//    }


}
