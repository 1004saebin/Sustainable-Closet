package com.example.sustainablecloset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

    }

    public void startLandingPage(View view){

        Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
        startActivity(intent);
    }


}

