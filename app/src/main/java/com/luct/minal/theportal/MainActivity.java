package com.luct.minal.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyActivity extends ActionBarActivity {

    private EditText emailEditText;
    private EditText passEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        emailEditText = (EditText) findViewById(R.id.email_edit_Text);
        passEditText = (EditText) findViewById(R.id.edit_text_password);
        registerButton = (Button) findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String email = emailEditText.getText().toString();
                final String password = passEditText.getText().toString();
                if (!isValidEmail(email)) {
                    emailEditText.setError("Invalid Email");
                    emailEditText.requestFocus();
                } else if (!isValidPassword(password)) {
                    passEditText.setError("Invalid Password");
                    passEditText.requestFocus();
                } else {
                    Toast.makeText(view.getContext(), "You have created account successfully !!",
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
