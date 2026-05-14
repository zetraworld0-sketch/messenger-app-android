package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB - CORE BUILD
 * Using Object-based parameters to bypass SDK version conflicts.
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

    // BYPASS: Using Object to ensure the build enters successfully
    @Override
    public boolean Mesibo_onMessage(Object params, byte[] data) {
        showStatus("Netscape: Hub Online");
        return true;
    }

    @Override
    public void Mesibo_onMessageStatus(Object params) {
    }

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Hub Online");
        }
    }

    @Override
    public boolean Mesibo_onFile(Object params, Object fileInfo) {
        return true;
    }
}
