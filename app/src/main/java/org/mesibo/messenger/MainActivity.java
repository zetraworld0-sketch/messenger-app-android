package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB - FULL UNIT 1 (MESSAGING)
 * Using Direct Pathing to resolve SDK symbol errors.
 */
public class MainActivity extends AppCompatActivity implements 
        Mesibo.ConnectionListener, 
        Mesibo.MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mesibo api = Mesibo.getInstance();
        api.init(getApplicationContext());
        
        Mesibo.addListener(this);
        
        Mesibo.setSecureAndInsecureConnection(true, true);
        Mesibo.start();
    }

    private void showStatus(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // --- MESSAGING NET LOGIC ---
    
    @Override
    public boolean Mesibo_onMessage(Mesibo.MessageParams params, byte[] data) {
        try {
            String messageContent = new String(data, "UTF-8");
            showStatus("Netscape Message Received");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(Mesibo.MessageParams params) {
        // Verification for the Zetra ecosystem
    }

    // --- CONNECTION LOGIC ---

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        }
    }

    @Override
    public boolean Mesibo_onFile(Mesibo.MessageParams params, Mesibo.FileInfo fileInfo) {
        return true;
    }
}
