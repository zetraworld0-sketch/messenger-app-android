package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.mesibo.api.Mesibo;
import com.mesibo.api.Mesibo.ConnectionListener;
import com.mesibo.api.Mesibo.MessageListener;

// These are likely standalone imports in your version
import com.mesibo.api.Mesibo.MessageParams;
import com.mesibo.api.Mesibo.FileInfo;

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

    @Override
    public boolean Mesibo_onMessage(MessageParams params, byte[] data) {
        showStatus("Netscape: Message Received");
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(MessageParams params) {
    }

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        }
    }

    @Override
    public boolean Mesibo_onFile(MessageParams params, FileInfo fileInfo) {
        return true;
    }
}
