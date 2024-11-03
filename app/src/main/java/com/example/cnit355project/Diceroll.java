package com.example.cnit355project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Diceroll extends AppCompatActivity {


    Random random = new Random();
    ImageView one, two, three, four, five, six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diceroll);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        one = (ImageView)findViewById(R.id.imageView1);
        two = (ImageView)findViewById(R.id.imageView2);
        three = (ImageView)findViewById(R.id.imageView3);
        four = (ImageView)findViewById(R.id.imageView4);
        five = (ImageView)findViewById(R.id.imageView5);
        six = (ImageView)findViewById(R.id.imageView6);


        one.setVisibility(View.VISIBLE);
        two.setVisibility(View.GONE);
        three.setVisibility(View.GONE);
        four.setVisibility(View.GONE);
        five.setVisibility(View.GONE);
        six.setVisibility(View.GONE);
    }

    public void onBackClick(View view){
        Intent mIntent = new Intent(Diceroll.this, MainActivity.class);
        Diceroll.this.startActivity(mIntent);
        finish();
    }

    public void onRollDieClick(View view) {
        int value = random.nextInt(6); //generate either 0 or 1
        if (value == 0) {
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.GONE);

        } else if (value == 1){
            one.setVisibility(View.GONE);
            two.setVisibility(View.VISIBLE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.GONE);
        } else if (value == 2){
            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.VISIBLE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.GONE);
        } else if (value == 3){
            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.VISIBLE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.GONE);
        } else if (value == 4){
            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.VISIBLE);
            six.setVisibility(View.GONE);
        } else {
            one.setVisibility(View.GONE);
            two.setVisibility(View.GONE);
            three.setVisibility(View.GONE);
            four.setVisibility(View.GONE);
            five.setVisibility(View.GONE);
            six.setVisibility(View.VISIBLE);
        }
    }
}