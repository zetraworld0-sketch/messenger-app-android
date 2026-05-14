package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB
 * Finalized Institutional-Grade Build
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
        
        // Register the listener to handle real-time data
        Mesibo.addListener(this);
        
        // Start the Mesibo Engine
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

    // RESOLUTION FOR ERROR: Mesibo_onMessage signature
    @Override
    public boolean Mesibo_onMessage(Mesibo.MessageParams params, byte[] data) {
        showStatus("Netscape Hub: Message Received");
        return true;
    }

    // RESOLUTION FOR ERROR: Missing Mesibo_onMessageUpdate
    // This was the "smoking gun" in your log. It must be present.
    @Override
    public void Mesibo_onMessageUpdate(Mesibo.MesiboMessage message) {
        // Handled by SDK version requirements
    }

    @Override
    public void Mesibo_onMessageStatus(Mesibo.MessageParams params) {
    }

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
