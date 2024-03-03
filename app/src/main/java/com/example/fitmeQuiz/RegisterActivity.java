package com.example.fitmeQuiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Assuming you have defined fields in activity_register.xml for name, family name, etc.

        Button registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get references to EditText fields
                EditText nameEditText = findViewById(R.id.name_edit_text);
                EditText familyNameEditText = findViewById(R.id.family_name_edit_text);
                EditText emailEditText = findViewById(R.id.email_edit_text);
                EditText passwordEditText = findViewById(R.id.password_edit_text);

                // Get input values
                String name = nameEditText.getText().toString().trim();
                String familyName = familyNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Perform validation
                if (name.isEmpty() || familyName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    // Show error message for empty fields
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (name.length() < 3 || name.length() > 30) {
                    // Show error message for invalid name length
                    Toast.makeText(RegisterActivity.this, "Name should be between 3 and 30 characters", Toast.LENGTH_SHORT).show();
                } else if (familyName.length() < 3 || familyName.length() > 30) {
                    // Show error message for invalid family name length
                    Toast.makeText(RegisterActivity.this, "Family name should be between 3 and 30 characters", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    // Show error message for invalid email format
                    Toast.makeText(RegisterActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                } else {
                    // Registration successful, you can proceed with registration logic here
                    // Once registration is done, navigate back to the previous page
                    Intent intent = new Intent(RegisterActivity.this, LoginRegisterActivity.class);
                    startActivity(intent);
                    finish(); // Finish current activity to prevent going back to it by pressing back button
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
