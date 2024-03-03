package com.example.fitmeQuiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button historyButton = findViewById(R.id.history_button);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });


        // Retrieve score and total questions from intent
        int score = getIntent().getIntExtra("SCORE", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 0);

        // Display score
        TextView scoreTextView = findViewById(R.id.score_text_view);
        scoreTextView.setText("Your Score: " + score + "/" + totalQuestions);

        // Determine the quiz number
        SharedPreferences sharedPreferences = getSharedPreferences("QuizResults", MODE_PRIVATE);
        int quizCount = sharedPreferences.getAll().size();
        int quizNumber = quizCount + 1; // Increment by 1 to get the next quiz number

        // Display quiz number
        TextView quizNumberTextView = findViewById(R.id.quiz_number_text_view);
        if (quizCount == 0) {
            storeQuizResult("Quiz 1",score);
            quizNumberTextView.setText("Quiz 1");
        } else {
            storeQuizResult("Quiz " + quizNumber,score);
            quizNumberTextView.setText("Quiz " + quizNumber);
        }



    }

    private void storeQuizResult(String quizName, int score) {
        SharedPreferences sharedPreferences = getSharedPreferences("QuizResults", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(quizName, score);
        editor.apply();
    }
}
