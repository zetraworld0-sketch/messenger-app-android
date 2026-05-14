package org.mesibo.messenger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.mesibo.api.Mesibo;
import com.mesibo.api.MesiboMessage;
import com.mesibo.api.MessageParams;
import com.mesibo.api.FileInfo;

public class MainActivity extends AppCompatActivity implements Mesibo.MessageListener, Mesibo.ConnectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mesibo api = Mesibo.getInstance();
        api.init(getApplicationContext());
        
        Mesibo.addListener(this);
        Mesibo.start();
    }

    @Override
    public void Mesibo_onConnectionStatus(int status) {
    }

    @Override
    public boolean Mesibo_onMessage(MessageParams params, byte[] data) {
        return true;
    }

    @Override
    public void Mesibo_onMessageUpdate(MesiboMessage message) {
    }

    @Override
    public void Mesibo_onMessageStatus(MessageParams params) {
    }

    @Override
    public boolean Mesibo_onFile(MessageParams params, FileInfo fileInfo) {
        return true;
    }
}
