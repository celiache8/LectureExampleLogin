package com.example.celiachen.lectureexamplelogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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

    }


    public void yesChecked(View view){
        yesChecked = ((CheckBox) view).isChecked();
    }


    public void noChecked(View view){
        noChecked = ((CheckBox) view).isChecked();
    }





}
