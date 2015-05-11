package com.luct.minal.theportal;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    private EditText  username=null;
    private EditText  password=null;

    private Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);


        loginbutton = (Button)findViewById(R.id.imageButton3);
        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String email = username.getText().toString();
                final String password = password.getText().toString();
                if (!isValidEmail(email)) {
                    username.setError("Invalid username");
                    username.requestFocus();
                } else if (!isValidPassword(password)) {
                    password.setError("Invalid Password");
                    password.requestFocus();
                } else {
                    Toast.makeText(view.getContext(), "You have logged in successfully !!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
}
    }


}