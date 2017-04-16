package com.example.tinohacks.connectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Home extends AppCompatActivity {

    private String username;
    private String email;
    private String name;
    private String zip;
    private String password;
    private String interest;
    private Button update;
    private Button create;
    public String searchName;
    private SearchView searchView;


    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);


        update = (Button) findViewById(R.id.update);
        create = (Button) findViewById(R.id.create);
        //SearchView searchMenuItem = (R.id.searchView);
        searchView = (SearchView) findViewById(R.id.searchView);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), UpdateSchedule.class);
                startActivity(i);


            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CreateSchedule.class);
                startActivity(i);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchName = query;

                myRef.addValueEventListener(new ValueEventListener() {
                    int counter1 = 0;
                    @Override


                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot d : dataSnapshot.getChildren()) {
                            if (d.getKey().equals("User " + searchName)) {
                                Toast.makeText(Home.this, "FOUND!", Toast.LENGTH_SHORT).show();

                                counter1++;
                                break;
                            }
                            Toast.makeText(Home.this, d.getKey(), Toast.LENGTH_SHORT).show();

                        }
                        if (counter1 == 0) {
                            Toast.makeText(Home.this, searchName + " NOT FOUND!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //Toast.makeText(Home.this, myRef.child("User " + searchName) + " this", Toast.LENGTH_SHORT).show();

                if (searchName != null) {


                } else {

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });














    }
}
