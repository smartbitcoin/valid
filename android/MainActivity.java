package app.com.neil.validity.vaiidity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button bMyID = (Button) findViewById(R.id.button);
        Button bCheckID = (Button) findViewById(R.id.button2);
        bMyID.getBackground().setColorFilter(0xFF3c8a2e, PorterDuff.Mode.MULTIPLY);
        bCheckID.getBackground().setColorFilter(0xFF3c8a2e, PorterDuff.Mode.MULTIPLY);
        bMyID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                i.putExtra("URL", "http://54.209.69.190:8080/valid/index1.html");
                startActivity(i);
            }
        });
        bCheckID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent, 0);
                } catch(Exception e) {
                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                    startActivity(marketIntent);
                }
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT"); // This will contain your scan result
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast.makeText(getApplicationContext(), "Result:\n" + contents + "\nFormat" + format, Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                i.putExtra("URL", contents);
                startActivity(i);
            }
        }
    }
}
