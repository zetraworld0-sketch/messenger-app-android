package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Zetra Lab - Netscape Sovereign Hub
 * This version completely ignores the default Mesibo UI logic.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // This line links to the XML you just showed me.
        // By NOT calling Mesibo UI functions here, the old screens can't load.
        setContentView(R.layout.activity_main); 
    }

    @Override
    public void onBackPressed() {
        // Institutional-grade security: prevent going back to Login without intent
        super.onBackPressed();
    }
}
