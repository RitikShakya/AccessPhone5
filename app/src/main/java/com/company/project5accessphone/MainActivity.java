package com.company.project5accessphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button phonecall,sendmessage,sendemail,voicerecog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Access Phone");
        setContentView(R.layout.activity_main);

        phonecall = findViewById(R.id.PhoneCall);
        sendemail= findViewById(R.id.SendEmail);
        sendmessage= findViewById(R.id.SendMsg);
        voicerecog = findViewById(R.id.Speech);

        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PhoneCall.class);
                startActivity(intent);
                finish();
            }
        });
        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SendEmail.class);
                startActivity(intent);
                finish();
            }
        });
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SendMessage.class);
                startActivity(intent);
                finish();
            }
        });
        voicerecog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VoiceRecog.class);
                startActivity(intent);
                finish();
            }
        });
    }
}