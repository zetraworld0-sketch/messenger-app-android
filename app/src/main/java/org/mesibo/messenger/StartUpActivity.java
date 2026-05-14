package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ZETRA PURGE PROTOCOL - VERSION 2.0
 * Neutralized while maintaining symbol compatibility for compilation.
 */
public class StartUpActivity extends AppCompatActivity {

    // Dummy variables to satisfy MesiboListeners and UIManager
    public final static String STARTINBACKGROUND = "startinbackground";
    public final static String SKIPTOUR = "skipTour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Kill the activity instantly if it's ever called
        finish(); 
    }

    /**
     * Dummy method to satisfy any remaining calls in the source code
     */
    public static void newInstance(android.content.Context context, boolean startInBackground) {
        // Do nothing
    }
}
