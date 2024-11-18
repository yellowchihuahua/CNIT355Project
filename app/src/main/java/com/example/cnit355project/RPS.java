package com.example.cnit355project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RPS extends AppCompatActivity {

    ImageButton rockButton, paperButton, scissorsButton;
    TextView playerPromptText;

    String current = "Rock";

    int playerTurn = 1;
    String player1Selection;
    String player2Selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rps);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        playerPromptText = (TextView) findViewById(R.id.textView);
        rockButton = (ImageButton) findViewById(R.id.imageButtonRock);
        paperButton = (ImageButton) findViewById(R.id.imageButtonPaper);
        scissorsButton = (ImageButton) findViewById(R.id.imageButtonScissors);
    }

    public void onBackClick(View view){
        Intent mIntent = new Intent(RPS.this, MainActivity.class);
        RPS.this.startActivity(mIntent);
        finish();
    }

    public void onClickRock(View view){
        current = "Rock";
        rockButton.setBackgroundResource(R.color.red);
        paperButton.setBackgroundResource(R.color.gray);
        scissorsButton.setBackgroundResource(R.color.gray);

    }
    public void onClickPaper(View view){
        current = "Paper";
        rockButton.setBackgroundResource(R.color.gray);
        paperButton.setBackgroundResource(R.color.red);
        scissorsButton.setBackgroundResource(R.color.gray);
    }
    public void onClickScissors(View view){
        current = "Scissors";
        rockButton.setBackgroundResource(R.color.gray);
        paperButton.setBackgroundResource(R.color.gray);
        scissorsButton.setBackgroundResource(R.color.red);
    }

    public void onClickSubmit(View view){
        if(playerTurn == 1) {
            player1Selection = current; //save the current selection to player1Selection
            current = ""; //clear current selection
            playerPromptText.setText("Player 2:");
            playerTurn++; //increment player 2
        } else { //otherwise, player turn is 2
            player2Selection = current;
            //huge if statement to determine winner
            if (player1Selection.equals("scissors") && player2Selection.equals("paper")){
                displayWinner(1);
            } else if (player1Selection.equals("rock") && player2Selection.equals("scissors")) {
                displayWinner(1);
            } else if (player1Selection.equals("paper") && player2Selection.equals("rock")) {
                displayWinner(1);
            } else if (player1Selection.equals("scissors") && player2Selection.equals("rock")) {
                displayWinner(2);
            } else if (player1Selection.equals("rock") && player2Selection.equals("paper")) {
                displayWinner(2);
            } else if (player1Selection.equals("paper") && player2Selection.equals("scissors")){
                displayWinner(2);
            } else {
                displayWinner(0);
            }


        }
    }

    private void displayWinner(int winnerNum){
        Intent mIntent = new Intent(this, RPSWinner.class);
        mIntent.putExtra("winnerNum", winnerNum);
        startActivity(mIntent);
        finish();

    }
}