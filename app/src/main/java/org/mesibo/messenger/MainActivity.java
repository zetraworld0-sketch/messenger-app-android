package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

// THE WILDCARD MOVE: This imports everything in the API so nothing is "missing"
import com.mesibo.api.*;

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

    // Logic for Unit 1: Messaging Net
    @Override
    public boolean Mesibo_onMessage(Mesibo.MessageParams params, byte[] data) {
        showStatus("Netscape Hub: Data Received");
        return true;
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
