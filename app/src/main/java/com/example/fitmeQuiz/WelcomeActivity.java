package com.example.fitmeQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get username from intent extras
        Button rulesButton = findViewById(R.id.rules_button);
        Button startGameButtom = findViewById(R.id.start_game_button);
        Button historyButton = findViewById(R.id.history_button);


        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RulesActivity.class);
                startActivity(intent);
            }
        });
        startGameButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to register page
                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to register page
                Intent intent = new Intent(WelcomeActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

//    public void startGame(View view) {
//        Intent intent = new Intent(this, GameActivity.class);
//        startActivity(intent);
//    }
//
//    // Method to start the rules activity
//    public void showRules(View view) {
//        Intent intent = new Intent(this, RulesActivity.class);
//        startActivity(intent);
//    }
}
