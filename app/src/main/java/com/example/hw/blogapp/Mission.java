package com.example.hw.blogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Mission extends AppCompatActivity {

    private TextView mTextView;
    private Firebase firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        Firebase.setAndroidContext(this);

        mTextView = findViewById(R.id.fMission);

        firebase = new Firebase("https://ashok-goyal-app.firebaseio.com/mission");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String abc = dataSnapshot.getValue(String.class);
                mTextView.setText(abc);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
}
