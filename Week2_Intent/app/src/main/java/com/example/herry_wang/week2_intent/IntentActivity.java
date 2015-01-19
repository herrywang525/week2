package com.example.herry_wang.week2_intent;

/**
 * Created by Herry_Wang on 2015/1/19.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


public class IntentActivity extends Activity {

    final String TAG= "States";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent dial = new Intent();
        dial.setAction("android.intent.action.CALL");
        dial.setData(Uri.fromParts("tel", "123321", null));
        startActivity(dial);

        Intent intent = getIntent();
        Uri data = intent.getData();

        // Figure out what to do based on the intent type
        if (intent.getType().indexOf("image/") != -1) {
            Log.d(TAG, "get an image.");
        } else if (intent.getType().equals("text/plain")) {
            Log.d(TAG, "get a text.");
        }

        registerReceiver(
                new ThikReceiver(),
                new IntentFilter(Intent.ACTION_TIME_TICK));


// Get the intent that started this activity

    }




    public class ThikReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            context = getApplicationContext();
            CharSequence text = "Receive time tick intent.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        }
    }

}