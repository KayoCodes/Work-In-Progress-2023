package com.example.work_in_progress_2023;

import androidx.activity.ComponentActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.Scanner;

public class LoginActivity extends ComponentActivity {
    AssetManager assets;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        assets = getAssets();
        setupButtons();
    }


    private boolean authenticate( String username, String password ) {
        Scanner scan;
        String str = "";
        String[] arr;
        boolean authenticated = false;

        try {
            scan = new Scanner(assets.open("login.txt"));

            while (scan.hasNext()) {
                str = scan.nextLine();
                arr = str.split(",");
                if (username.equalsIgnoreCase(arr[1]) && password.equals(arr[2])) {
                    authenticated = true;
                    break;
                }
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return authenticated;
    }

    private void setupButtons(){
        button = (Button) findViewById(R.id.login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText uText = (EditText) findViewById(R.id.login_username_input);
                EditText pText = (EditText) findViewById(R.id.login_password_input);

                if( authenticate(uText.getText().toString(), pText.getText().toString()) ){
                    Intent intent = new Intent( LoginActivity.this, profileActivity.class);
                    startActivity(intent);
                }
                else{
                    uText.setText(""); // clears username field for user to reenter
                    pText.setText(""); // clears password field for user to reenter

                    uText.setError("Incorrect username and password combination");
                    pText.setError("Incorrect username and password combination");
                }
            }
        });
    }
}

