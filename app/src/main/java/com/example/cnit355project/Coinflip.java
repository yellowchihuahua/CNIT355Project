package com.example.cnit355project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Coinflip extends AppCompatActivity {


    Random random = new Random();
    ImageView heads, tails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coinflip);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        heads = (ImageView)findViewById(R.id.imageView1);
        tails = (ImageView)findViewById(R.id.imageView2);


        heads.setVisibility(View.VISIBLE);
        tails.setVisibility(View.GONE);
    }

    public void onBackClick(View view){
        Intent mIntent = new Intent(Coinflip.this, MainActivity.class);
        Coinflip.this.startActivity(mIntent);
        finish();
    }

    public void onCoinFlipClick(View view) {
        int value = random.nextInt(2); //generate either 0 or 1
        if (value == 0) {
            heads.setVisibility(View.VISIBLE);
            tails.setVisibility(View.GONE);

        } else {
            heads.setVisibility(View.GONE);
            tails.setVisibility(View.VISIBLE);
        }
    }
}