package org.mesibo.messenger;

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

        final EditText emailField = findViewById(R.id.email_input);
        final EditText passwordField = findViewById(R.id.password_input);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Institutional-grade validation check
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(CustomLoginActivity.this, "Credentials required", Toast.LENGTH_SHORT).show();
                } else {
                    // Logic to proceed to the Main Hub
                    Intent intent = new Intent(CustomLoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
