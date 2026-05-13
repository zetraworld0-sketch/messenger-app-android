package org.mesibo.messenger;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This will point to your hub's main dashboard later
        setContentView(R.layout.activity_main); 
    }
}
