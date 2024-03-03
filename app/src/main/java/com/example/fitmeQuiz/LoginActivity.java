package com.example.fitmeQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get username and password from EditText fields
                EditText usernameEditText = findViewById(R.id.username_edit_text);
                EditText passwordEditText = findViewById(R.id.password_edit_text);

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if username or password is empty
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    // Show a toast message indicating that fields are required
                    Toast.makeText(LoginActivity.this, "Username and password are required.", Toast.LENGTH_SHORT).show();
                } else {
                    // For now, let's just navigate to the welcome page
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}
