package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.mesibo.api.Mesibo;

/**
 * NETSCAPE SOVEREIGN HUB - MESSAGING NET CORE
 * Built to Zetra Lab standards. This is the "Engine Room" of the first Net.
 */
public class MainActivity extends AppCompatActivity implements Mesibo.ConnectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INITIALIZE THE ENGINE
        // This connects your Hub to the global Netscape infrastructure.
        Mesibo api = Mesibo.getInstance();
        api.init(getApplicationContext());

        // Add the listener so the app knows when it's online
        Mesibo.addListener(this);

        // Start the background synchronization
        Mesibo.setSecureAndInsecureConnection(true, true);
        Mesibo.start();

        // Check if we are ready to operate
        if(Mesibo.getConnectionStatus() == Mesibo.STATUS_ONLINE) {
            showStatus("Netscape Hub: Online");
        }
    }

    private void showStatus(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // --- MECHANICAL LISTENERS ---
    // These ensure the app "works" across all global nodes.

    @Override
    public void Mesibo_onConnectionStatus(int status) {
        if (status == Mesibo.STATUS_ONLINE) {
            showStatus("Sovereign Connection Established");
        } else if (status == Mesibo.STATUS_AUTHFAIL) {
            showStatus("Identity Verification Failed");
        }
    }
}
