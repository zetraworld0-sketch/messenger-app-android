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
        
        // This will link to the layout we create in the next step
        setContentView(R.layout.activity_splash); 

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Logic: If no token, go to Custom Login. Otherwise, go to Main.
                if (Mesibo.getInstance().getAccessToken() == null) {
                    startActivity(new Intent(SplashActivity.this, CustomLoginActivity.class));
                } else {
                    // This points to your main hub dashboard
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        }, 2000);
    }
}
