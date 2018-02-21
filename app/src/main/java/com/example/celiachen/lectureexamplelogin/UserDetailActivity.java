package com.example.celiachen.lectureexamplelogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by celiachen on 2/14/18.
 */

public class UserDetailActivity extends AppCompatActivity {

    private Context mContext;
    private ImageButton goBackButton;
    private TextView welcomeText;
    private boolean yesChecked;
    private boolean noChecked;

    private EditText longitudeText;
    private EditText latitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);


        mContext = this;
        goBackButton = findViewById(R.id.go_back_button);
        welcomeText = findViewById(R.id.welcome_view);

        goBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // construct intent
                Intent checkboxIntent = new Intent();
                // put the two boolean values into the intent
                checkboxIntent.putExtra("yes", yesChecked);
                checkboxIntent.putExtra("no", noChecked);
                // send back to main activity
                setResult(RESULT_OK, checkboxIntent);
                finish();


            }
        });

        // change welcomeText to display: username + welcome back!
        String username = this.getIntent().getExtras().getString("username");
        welcomeText.setText(username + ", welcome back!");

        longitudeText = findViewById(R.id.longitude);
        latitudeText = findViewById(R.id.latitude);
    }


    public void yesChecked(View view){
        yesChecked = ((CheckBox) view).isChecked();
    }


    public void noChecked(View view){
        noChecked = ((CheckBox) view).isChecked();
    }

    public void openMap(View view){
        // APIs for location stuff
        // send a static string with location - long & lat
        Uri geoLocation = null;
        // 34.1260° N, 118.2142° W
        //String location = "geo:34.1260,-118.2142";
        //String location = "google.streetview:cbll=34.1260,-118.2142";
        //"geo:37.7749,-122.4194?q=restaurants"
        //String location = "geo:" + longitudeText.getText().toString() + "," + latitudeText.getText().toString();

        //geo:0,0?q=-33.8666,151.1957(Google+Sydney)
        //String location = "geo:" + longitudeText.getText().toString() + "," + latitudeText.getText().toString() +"?q=restaurants";

        String location = "geo:0,0?q="+longitudeText.getText().toString() + ","
                + latitudeText.getText().toString()
                +"(Occidental College)";

        geoLocation = Uri.parse(location);

        // REMINDER: Talk about Speakers event
        // set up an intent
        // pack geoLocation to the intent
        // start intent

        Intent intent = new Intent(Intent.ACTION_VIEW); // implicit, no destination needed
        intent.setData(geoLocation);

        // if there is any app that can receive this intent
        // start the app with the intent
        System.out.println(intent.resolveActivity(getPackageManager()));

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }


    }



}

