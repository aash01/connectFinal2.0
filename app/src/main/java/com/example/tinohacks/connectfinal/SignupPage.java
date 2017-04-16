package com.example.tinohacks.connectfinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SignupPage extends AppCompatActivity {
    Button signUp;
    EditText nameInput;
    String name;
    String zip;
    String email;
    String password;
    String interest;
    String username;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(SignupPage.this).create();
                alertDialog.setTitle("Success!");
                alertDialog.setMessage("Signup Successful, Please Login");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                username =  ((EditText) findViewById(R.id.username)).getText().toString();
                                name = ((EditText) findViewById(R.id.nameInput)).getText().toString();
                                zip = ((EditText) findViewById(R.id.zipCode)).getText().toString();
                                email = ((EditText) findViewById(R.id.email)).getText().toString();
                                password = ((EditText) findViewById(R.id.password)).getText().toString();
                                interest = ((EditText) findViewById(R.id.interest)).getText().toString();


                                user = new User(username, name, email, zip, password, interest);
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                            }
                        });
                alertDialog.show();


            }
        });


    }
}
