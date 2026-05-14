package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

// Explicit imports for Mesibo classes to resolve "Symbol Not Found"
import com.mesibo.api.Mesibo;
import com.mesibo.api.Mesibo.MessageParams;
import com.mesibo.api.Mesibo.MesiboMessage;
import com.mesibo.api.Mesibo.FileInfo;

/**
 * NETSCAPE SOVEREIGN HUB
 * Finalized for SDK Compatibility & Explicit Symbol Resolution
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
        
        // Add the listener
        Mesibo.addListener(this);
        
        // Start the engine
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

    // Resolves: error: cannot find symbol class MessageParams
    @Override
    public boolean Mesibo_onMessage(MessageParams params, byte[] data) {
        showStatus("Netscape Hub: Message Received");
        return true;
    }

    // Resolves: error: cannot find symbol class MesiboMessage
    @Override
    public void Mesibo_onMessageUpdate(MesiboMessage message) {
        // Mandatory for this SDK version
    }

    // Resolves: error: cannot find symbol class MessageParams
    @Override
    public void Mesibo_onMessageStatus(MessageParams params) {
    }

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        }
    }

    // Resolves: error: cannot find symbol class FileInfo
    @Override
    public boolean Mesibo_onFile(MessageParams params, FileInfo fileInfo) {
        return true;
    }
}
