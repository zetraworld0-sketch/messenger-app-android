package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.mesibo.api.Mesibo;

public class MainActivity extends AppCompatActivity implements 
        Mesibo.ConnectionListener, 
        Mesibo.MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mesibo api = Mesibo.getInstance();
        api.init(getApplicationContext());
        
        // Add the listener to the API
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

    // Fix 1: Correct signature for Message Listener
    @Override
    public boolean Mesibo_onMessage(Mesibo.MessageParams params, byte[] data) {
        showStatus("Netscape Hub: Message Received");
        return true;
    }

    // Fix 2: Added the missing mandatory method from your error log
    @Override
    public void Mesibo_onMessageUpdate(Mesibo.MesiboMessage message) {
        // Required by the SDK version you are using
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
