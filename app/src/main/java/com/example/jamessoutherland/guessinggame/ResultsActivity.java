package com.example.jamessoutherland.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.VISIBLE;
import static com.example.jamessoutherland.guessinggame.GameActivity.winningNumber;

public class ResultsActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumberTextview;
    private TextView resultsTextview;
    private ImageView resultsImageview;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // get winning number from intent If user has lost


        playAgainButton = findViewById(R.id.restart_button);
        correctNumberTextview = findViewById(R.id.number_textview);
        resultsTextview = findViewById(R.id.results_textview);
        resultsImageview = findViewById(R.id.winning_imageview);

        setListener();
        intent = getIntent();
        if(intent.hasExtra(winningNumber)) {
            setLosingData();
        }
    }

    private void setLosingData() {
        int winningNumber = intent.getIntExtra(GameActivity.winningNumber,0);
        resultsTextview.setText("You lost!!");
        correctNumberTextview.setText(getString(R.string.the_winning_number_was_1_d,winningNumber));
        correctNumberTextview.setVisibility(VISIBLE);

        resultsImageview.setImageResource(R.drawable.losingsadface);
    }

    private void setListener() {


        playAgainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
