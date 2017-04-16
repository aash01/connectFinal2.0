package com.example.tinohacks.connectfinal;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by TinoHacks on 4/15/17.
 */

public class User {
    private String username;
    private String email;
    private String name;
    private String zip;
    private String password;
    private String interest;
    private String schedule;
    public String nothing;


    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference("Users");
    public User(String username, String name, String email,String zip,String password,String interest) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.zip = zip;
        this.password = password;
        this.interest = interest;
        //myRef.child("Test").setValue("Testing");
        writeNewUser(username, name, email, zip, password, interest);

    }
    public void writeNewUser(String ID, String name, String email, String zip, String password, String interest) {
        HashMap<String, Objects> map = new HashMap<>();


        myRef.child("User " + ID).child("name").setValue(name);
        myRef.child("User " + ID).child("email").setValue(email);
        myRef.child("User " + ID).child("zip").setValue(zip);
        myRef.child("User " + ID).child("password").setValue(password);
        myRef.child("User " + ID).child("interest").setValue(interest);
        myRef.child("User " + ID).child("schedule").child("activity1").setValue("");
        myRef.child("User " + ID).child("schedule").child("activity2").setValue("");
        myRef.child("User " + ID).child("schedule").child("activity3").setValue("");
        myRef.child("User " + ID).child("schedule").child("activity4").setValue("");
        myRef.child("User " + ID).child("schedule").child("activity5").setValue("");

    }

    public static void newBranchInFirebase(String child, String key, String value) {
        myRef.child(MainActivity.currentUser).child(key).setValue(value);
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPassword() {
//
//    }




}
