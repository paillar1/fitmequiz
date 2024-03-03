package com.example.fitmeQuiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Display quiz history
        TextView historyTextView = findViewById(R.id.history_text_view);
        historyTextView.setText(getQuizHistory());
    }

    private String getQuizHistory() {
        SharedPreferences sharedPreferences = getSharedPreferences("QuizResults", MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();
        StringBuilder history = new StringBuilder();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            history.append(entry.getKey()).append(": ").append(entry.getValue()).append(" points\n");
        }
        return history.toString();
    }
}
