package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

public class ClosetActivity extends AppCompatActivity {

    Button btnSend = null;
    private GridView grid;
    private List<String> listOfImagesPath;

    public static final String GridViewDemo_ImagePath =
            Environment.getExternalStorageDirectory().getAbsolutePath()+"/GridViewDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_closet);


    }
}
