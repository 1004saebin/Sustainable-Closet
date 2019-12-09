package com.example.sustainablecloset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class StackView extends View {

    private ArrayList<String> ImgArr = new ArrayList<>();

    public StackView(Context context) {
        super(context);
        ImgArr.add("./outfit_recommend_1.jpeg");
    }

    public StackView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
