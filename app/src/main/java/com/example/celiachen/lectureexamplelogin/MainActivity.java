package com.example.celiachen.lectureexamplelogin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private Context mContext;
    private Button mLoginButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get this context
        mContext = this;

        // find the edit text view from the layout
        // save it to the variable username
        username = findViewById(R.id.username);
        resultTextView = findViewById(R.id.resultTextView);

        // button?
        mLoginButton = findViewById(R.id.loginButton);

        // how do I start second activity when the login button is clicked
        mLoginButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchActivity();

            }
        });

    }

    private void launchActivity(){
        // package intent
        // start activity

        // 1. intent with from and to
        Intent intent = new Intent(mContext, UserDetailActivity.class);
        // 2. add data to the intent
        intent.putExtra("username", username.getText().toString());
        // 3. start activity with the intent
        //startActivity(intent);
        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) { // SECOND ACTIVITY IS SENDING DATA
                boolean yesBox = data.getBooleanExtra("yes", false);
                boolean noBox = data.getBooleanExtra("no", false);

                // check to see which box has been selected
                // then display different strings in the text view

                if (yesBox && !noBox){
                    resultTextView.setText("You love dogs!");
                }

                else if (!yesBox && noBox){
                    resultTextView.setText("No dog please.");
                }

                else if(yesBox && noBox){
                    resultTextView.setText("HUH?");
                }

                else{
                    resultTextView.setText("You have to select at least one.");
                }
            }

        }
    }

}
