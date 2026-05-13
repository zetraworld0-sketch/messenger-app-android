package com.zetra.netscape; // Ensure this matches your package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_login);

        EditText emailField = findViewById(R.id.email_input);
        EditText passwordField = findViewById(R.id.password_input);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                // Professional validation
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(CustomLoginActivity.this, "Please enter all credentials", Toast.LENGTH_SHORT).show();
                } else {
                    // This is where you'll eventually connect to your Zitra backend
                    Intent intent = new Intent(CustomLoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
