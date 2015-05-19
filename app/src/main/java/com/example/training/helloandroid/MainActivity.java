package com.example.training.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by training on 19/05/2015.
 */
public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final boolean DEVELOPER_MODE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
            }
        });

        //(new Thread().start();
    }


    public void finishActivity(View v){
        //finish();
        Toast.makeText(this,"Toast", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Initialiser ou Réinitialiser (récupération du gps)
        Log.d(TAG,"onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Appeler à chaque fois que l'activité redevient visible
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();


        // Traitement cours (libérer webcam ou autre ...)
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Traitement plus long tel que pousser des données en bdd ...

        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState()");
    }
}
