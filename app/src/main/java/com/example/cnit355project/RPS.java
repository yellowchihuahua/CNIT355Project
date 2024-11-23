package com.example.cnit355project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RPS extends AppCompatActivity {
    Button rock, paper, scissors;
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

        //calling objects into code
        playerPromptText = (TextView) findViewById(R.id.textView);
        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        //when button is clicked do method
        rock.setOnClickListener(v -> onClickRock());
        paper.setOnClickListener(v -> onClickPaper());
        scissors.setOnClickListener(v -> onClickScissors());
    }

    public void onBackClick(View view){
        Intent mIntent = new Intent(RPS.this, MainActivity.class);
        RPS.this.startActivity(mIntent);
        finish();
    }

    public void onClickRock(){
        current = "Rock";
        rock.setBackgroundColor(getResources().getColor(R.color.red));
        paper.setBackgroundColor(getResources().getColor(R.color.white));
        scissors.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void onClickPaper(){
        current = "Paper";
        paper.setBackgroundColor(getResources().getColor(R.color.red));
        scissors.setBackgroundColor(getResources().getColor(R.color.white));
        rock.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void onClickScissors(){
        current = "Scissors";
        scissors.setBackgroundColor(getResources().getColor(R.color.red));
        paper.setBackgroundColor(getResources().getColor(R.color.white));
        rock.setBackgroundColor(getResources().getColor(R.color.white));
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
            getWinner();}

    }
    private void getWinner(){
        int winner = 0; // Default is a tie
        String winningSelection;
        if (player1Selection.equals("Rock") && player2Selection.equals("Scissors") ||
                player1Selection.equals("Paper") && player2Selection.equals("Rock") ||
                player1Selection.equals("Scissors") && player2Selection.equals("Paper")) {
            winner = 1; // Player 1 wins
        } else if (player2Selection.equals("Rock") && player1Selection.equals("Scissors") ||
                player2Selection.equals("Paper") && player1Selection.equals("Rock") ||
                player2Selection.equals("Scissors") && player1Selection.equals("Paper")) {
            winner = 2; // Player 2 wins
        }

        if (winner == 1){
            winningSelection = player1Selection;
        } else {
            winningSelection = player2Selection;
        }

        displayWinner(winner, winningSelection); // Display the winner or tie
    }

    private void displayWinner(int winnerNum, String selection){
        Intent mIntent = new Intent(this, RPSWinner.class);
        mIntent.putExtra("winnerNum", winnerNum);
        mIntent.putExtra("winningSelection", selection);
        startActivity(mIntent);
        //finish();

    }
}