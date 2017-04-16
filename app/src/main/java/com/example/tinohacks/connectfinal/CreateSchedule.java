package com.example.tinohacks.connectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateSchedule extends AppCompatActivity {

    private Button save;
    private String activity1;
    private String activity2;
    private String activity3;
    private String activity4;
    private String activity5;
    public ArrayList<String> schedule;
    //private String username;




    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);
        //myRef = FirebaseDatabase.getInstance().getReference("Users").child(MainActivity.currentUser).child("Schedule");

        save = (Button) findViewById(R.id.saveSchedule);

        save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                activity1 =  ((EditText) findViewById(R.id.activity1)).getText().toString();
                activity2 =  ((EditText) findViewById(R.id.activity2)).getText().toString();
                activity3 =  ((EditText) findViewById(R.id.activity3)).getText().toString();
                activity4 =  ((EditText) findViewById(R.id.activity4)).getText().toString();
                activity5 =  ((EditText) findViewById(R.id.activity5)).getText().toString();


                //schedule = new ArrayList<String>();
/*
                Map<String, String> map = new HashMap<String, Object>();
                Map<String, String> map2 = new HashMap<String, Object>();
                Map<String, String> map3 = new HashMap<String, Object>();
                Map<String, String> map4 = new HashMap<String, Object>();
                Map<String, String> map5 = new HashMap<String, Object>();

                map.put("Activity1", activity1);
                map2.put("Activity2", activity2);
                map3.put("Activity3", activity3);
                map4.put("Activity4", activity4);
                map5.put("Activity5", activity5);
                myRef.child("Users").child("Schedule").updateChildren(;
                myRef.child(MainActivity.currentUser).child("Schedule").updateChildren(map2);
                myRef.child(MainActivity.currentUser).child("Schedule").updateChildren(map3);
                myRef.child(MainActivity.currentUser).child("Schedule").updateChildren(map4);
                myRef.child(MainActivity.currentUser).child("Schedule").updateChildren(map5);
/*
                writeNewPost("Activity1", activity1);
                writeNewPost("Activity2", activity2);
                writeNewPost("Activity3", activity3);
                writeNewPost("Activity4", activity4);
                writeNewPost("Activity5", activity5);

                Map<String, String> childUpdates = new HashMap<>();
                childUpdates.put(activity, activity);
                myRef.child("Users").child("Schedule").updateChildren(childUpdates);

*/

                schedule.add(activity1);
                schedule.add(activity2);
                schedule.add(activity3);
                schedule.add(activity4);
                schedule.add(activity5);
                String nothing = "";
//                myRef.child(MainActivity.currentUser).child("NEW").setValue("");
//                myRef.child(MainActivity.currentUser).child("schedule").child("activity1").setValue("ADFASF");
//                myRef.child(MainActivity.currentUser).child("schedule").child("activity2").setValue(nothing);
//                myRef.child(MainActivity.currentUser).child("schedule").child("activity3").setValue(nothing);
//                myRef.child(MainActivity.currentUser).child("schedule").child("activity4").setValue(nothing);
//                myRef.child(MainActivity.currentUser).child("schedule").child("activity5").setValue(nothing);


                myRef.child(MainActivity.currentUser).child("schedule").addValueEventListener(new ValueEventListener() {


                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot d : dataSnapshot.getChildren()) {
                            String key = d.getKey().toString();
                            myRef.child(MainActivity.currentUser).child("schedule").child(key).setValue("hoi");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);

            }
        });




/*
        public void writeNewPost(String activityName, String activity) {
            // Create new post at /user-posts/$userid/$postid and at
            // /posts/$postid simultaneously
            //String key = myRef.child("posts").push().getKey();



        }

*/







    }
}

