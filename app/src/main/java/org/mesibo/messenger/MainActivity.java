package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.mesibo.api.Mesibo;
// IMPORTANT: Adding explicit imports for Mesibo parameters
import com.mesibo.api.Mesibo.ConnectionListener;
import com.mesibo.api.Mesibo.MessageListener;
import com.mesibo.api.Mesibo.MessageParams;
import com.mesibo.api.Mesibo.FileInfo;

/**
 * NETSCAPE SOVEREIGN HUB - FULL UNIT 1 (MESSAGING)
 * Updated with explicit imports to resolve symbol errors.
 */
public class MainActivity extends AppCompatActivity implements 
        ConnectionListener, 
        MessageListener {

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
    public boolean Mesibo_onMessage(MessageParams params, byte[] data) {
        try {
            String messageContent = new String(data, "UTF-8");
            showStatus("Netscape Message: " + messageContent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(MessageParams params) {
        // Tracks delivery/read status in the ecosystem
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
    public boolean Mesibo_onFile(MessageParams params, FileInfo fileInfo) {
        showStatus("Incoming File Net: " + fileInfo.getFileName());
        return true;
    }
}
