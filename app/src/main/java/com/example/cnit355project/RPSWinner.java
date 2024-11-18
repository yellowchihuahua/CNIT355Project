package com.example.cnit355project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RPSWinner extends AppCompatActivity {


    TextView winnerDisplayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rpswinner);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        winnerDisplayText = findViewById(R.id.textView3);
        Intent mIntent = getIntent();
        if (mIntent == null) {
            return;
        }

        int winner = mIntent.getIntExtra("winnerNum",0);
        if(winner == 0){
            winnerDisplayText.setText("It's a Tie!");
        } else {
            winnerDisplayText.setText(String.format("Player %d Wins!", winner));
        }
    }

    public void onBackClick(View view){
        Intent mIntent = new Intent(RPSWinner.this, MainActivity.class);
        RPSWinner.this.startActivity(mIntent);
        finish();
    }

    public void onNewRPSClick(View view){
        Intent mIntent = new Intent(RPSWinner.this, RPS.class);
        RPSWinner.this.startActivity(mIntent);
        finish();
    }
}