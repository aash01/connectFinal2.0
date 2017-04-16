package com.example.tinohacks.connectfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.tinohacks.connectfinal.MainActivity.*;

public class UpdateSchedule extends AppCompatActivity {

    private EditText edittext1;
    private EditText edittext2;
    private EditText edittext3;
    private EditText edittext4;
    private EditText edittext5;
    private ArrayList<EditText> edittextList;


    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_schedule);

        edittextList = new ArrayList<>();
        edittext1 = (EditText) findViewById(R.id.activity1);
        //edittext1.setText(myRef.child(MainActivity.currentUser).child("Schedule").child("Activity1").);

        edittext2 = (EditText) findViewById(R.id.activity2);
        edittext3 = (EditText) findViewById(R.id.activity3);
        edittext4 = (EditText) findViewById(R.id.activity4);
        edittext5 = (EditText) findViewById(R.id.activity5);


        edittextList.add(edittext1);
        edittextList.add(edittext2);
        edittextList.add(edittext3);
        edittextList.add(edittext4);
        edittextList.add(edittext5);


//        Log.d(TAG, ("<--------------" + myRef.child(MainActivity.currentUser).child("Schedule")));
        myRef.child(MainActivity.currentUser).child("schedule").addValueEventListener(new ValueEventListener() {
            int counter = 0;

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {

                    //edittextList.get(counter).setText(d.getValue().toString());
                    //Toast.makeText(MainActivity.this, "TEST", Toast.LENGTH_SHORT).show();
                    counter++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //edittext1.setText(myRef.child(MainActivity.currentUser).child("Schedule").child("Activity1").toString().







    }
}
