package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB - UNIVERSAL ARCHITECTURE
 * Using Object-based parameters to bypass version-specific symbol errors.
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

    // Using Object to ensure compilation regardless of SDK version
    @Override
    public boolean Mesibo_onMessage(com.mesibo.api.Mesibo.MessageParams params, byte[] data) {
        showStatus("Netscape: Message Received");
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(com.mesibo.api.Mesibo.MessageParams params) {
        // Track delivery
    }

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        }
    }

    @Override
    public boolean Mesibo_onFile(com.mesibo.api.Mesibo.MessageParams params, com.mesibo.api.Mesibo.FileInfo fileInfo) {
        return true;
    }
}
