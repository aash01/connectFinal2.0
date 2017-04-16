package com.example.tinohacks.connectfinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button enter;
    EditText username;
    EditText password1;
    Button signUp;
    String realPassword;
    String currEmail;
    String currPassword;
    User user;
    //private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    //Hello Anjan!
    public static String currentUser;

    //Hi again!

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = (Button) findViewById(R.id.enter);
        username = (EditText) findViewById(R.id.username);
        password1 = (EditText) findViewById(R.id.password);
        signUp = (Button) findViewById(R.id.signUp);


        enter.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                //login to home
                myRef.child("User " + username.getText().toString()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot d : dataSnapshot.getChildren()) {
                            //Toast.makeText(MainActivity.this, "TEST", Toast.LENGTH_SHORT).show();
                            if (d.getKey().equals("password")) {
                                realPassword = d.getValue().toString();
                                //Toast.makeText(MainActivity.this, realPassword, Toast.LENGTH_SHORT).show();
                                doSomething(realPassword);
                                break;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupPage.class);
                startActivity(i);


            }
        });


    }
    public void doSomething(String realPassword) {
        if (realPassword != null && realPassword.equals(password1.getText().toString()) ) {

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Success!");
            alertDialog.setMessage("Login Successful, Welcome");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            currentUser = "User " + username;
                            Intent i = new Intent(getApplicationContext(), Home.class);
                            startActivity(i);


                        }
                    });
            alertDialog.show();


        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Failed!");
            alertDialog.setMessage("Signup Failed, Please Login Again");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }
    }
}




















            /*

        public void doSomething(String realPassword){
                if (realPassword != null && realPassword.equals(password1.getText().toString())) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Success!");
                    alertDialog.setMessage("Login Successful, Welcome");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();

                                    Intent i = new Intent(getApplicationContext(), Home.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();

                } else {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Failed!");
                    alertDialog.setMessage("Signup Failed, Please Login Again");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });


    }*/