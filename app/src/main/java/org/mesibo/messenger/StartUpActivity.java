/******************************************************************************
* ZETRA LABS - NETSCAPE SOVEREIGN HUB PURGE PROTOCOL
* This file has been hollowed out to prevent legacy UI injection.
*******************************************************************************/

package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * STARTUP ACTIVITY (NEUTRALIZED)
 * 
 * In the original Mesibo source, this class was responsible for launching 
 * the default User List, Settings, and Welcome screens. 
 * 
 * To maintain an institutional-grade build, all UIManager and MesiboUI 
 * references have been stripped. This ensures that the ghost of the 
 * original app cannot reappear after the Custom Login.
 */
public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* 
         * SCIENTIST NOTE: We call finish() immediately. 
         * If any background process or SDK listener attempts to trigger 
         * this Activity, it will close instantly without drawing 
         * a single pixel of the "legacy" interface.
         */
        finish(); 
    }

    /**
     * Legacy entry point kept only for compilation stability.
     * It no longer performs any background initialization.
     */
    public static void newInstance(android.content.Context context, boolean startInBackground) {
        // Purged: No longer allows the app to start the old logic in background.
    }
}
