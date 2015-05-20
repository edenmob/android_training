package com.example.training.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by brahima on 20/05/15.
 */
public class DetailActivity extends Activity {

    public static final String TAG = DetailActivity.class.getSimpleName();
    public static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);


        LinearLayout firstBlock = (LinearLayout)findViewById(R.id.firstBlock);
        firstBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG,"First Block is clicked");
            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        Toast.makeText(this, "Message : ["+message+"]", Toast.LENGTH_LONG).show();
        Log.d(TAG, message);
    }

    public void visitAndroid(View v){
        /*Uri android = Uri.parse("http://android.com");

        Intent intent = new Intent(Intent.ACTION_VIEW,android);

        PackageManager pm = getPackageManager();
        List activities = pm.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        boolean isSafeIntent = (activities.size() > 0);

        if(isSafeIntent){
            startActivity(intent);
        }*/

        pickContact();

    }

    public void displayNotification(View v){

        Log.d(TAG,"displayNotification");
        Intent intentService = new Intent(this,MyIntentService.class);
        intentService.setAction(MyIntentService.ACTION_NOTIF);
        intentService.putExtra(MyIntentService.EXTRA_PARAM1,"Ma superbe notification");
        startService(intentService);
    }

    /*public void downloadData(View v)
    {
        Log.d(TAG,"displayNotification");
        Intent service = new Intent(this,MyIntentService.class);
        startService(service);
    }*/

    private void pickContact() {

        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE); // Show user only contacts w/ emails
        //pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == PICK_CONTACT_REQUEST){
            if(resultCode == RESULT_OK)
            {
                Log.d(TAG,"Result OK");
                Log.d(TAG,data.toString());
            }else if(resultCode == RESULT_CANCELED){
                Log.d(TAG,"Cancelled");
                if(data != null){
                    Log.d(TAG,data.toString());
                }
            }
        }
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
        if(savedInstanceState != null){
            Log.d(TAG,savedInstanceState.toString());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState()");
    }
}
