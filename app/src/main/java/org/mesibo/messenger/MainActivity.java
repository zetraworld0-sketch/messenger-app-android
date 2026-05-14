package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB - FULL UNIT 1 (MESSAGING)
 * This handles the complete pipeline: Connection, Messaging, and Data.
 */
public class MainActivity extends AppCompatActivity implements 
        Mesibo.ConnectionListener, 
        Mesibo.MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Mesibo Engine
        Mesibo api = Mesibo.getInstance();
        api.init(getApplicationContext());
        
        // Register this Hub to listen for BOTH Connection and Messages
        Mesibo.addListener(this);
        
        Mesibo.setSecureAndInsecureConnection(true, true);
        Mesibo.start();
    }

    private void showStatus(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }

    // --- MESSAGING NET LOGIC ---
    
    @Override
    public boolean Mesibo_onMessage(Mesibo.MessageParams params, byte[] data) {
        try {
            String messageContent = new String(data, "UTF-8");
            
            // This is the heartbeat of the Messaging Net
            // It works for any data length, not just 10 digits.
            showStatus("Netscape Message: " + messageContent);
            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(Mesibo.MessageParams params) {
        // Tracks if your Net was delivered or read
    }

    // --- CONNECTION LOGIC ---

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        } else if (status == Mesibo.STATUS_AUTHFAIL) {
            showStatus("Zetra ID Auth Failed");
        }
    }

    @Override
    public boolean Mesibo_onFile(Mesibo.MessageParams params, Mesibo.FileInfo fileInfo) {
        showStatus("Incoming File Net: " + fileInfo.getFileName());
        return true;
    }
}
