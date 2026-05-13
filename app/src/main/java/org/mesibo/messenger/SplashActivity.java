package org.mesibo.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.mesibo.api.Mesibo;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 2-second delay to show the "Sovereign Hub" brand
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if user is already authenticated
                if (Mesibo.getInstance().getAccessToken() == null) {
                    // Navigate to Zetra Lab Custom Login
                    startActivity(new Intent(SplashActivity.this, CustomLoginActivity.class));
                } else {
                    // Navigate to Main Dashboard
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        }, 2000);
    }
}
