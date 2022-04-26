package com.company.project5accessphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends AppCompatActivity {

    EditText emailaddress,emailsub,emailmessage;

    Button sendEmail;
    String email ;
    String sub;
    String message ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Send Email");
        setContentView(R.layout.activity_send_email);

        emailaddress= findViewById(R.id.emailaddress);
        emailsub= findViewById(R.id.subjectemail);
        emailmessage = findViewById(R.id.messageemail);

        sendEmail = findViewById(R.id.Sendemailbtn);




        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=emailaddress.getText().toString();
                sub = emailsub.getText().toString();
                message= emailmessage.getText().toString();


                sendEmail(email,sub,message);

            }
        });


    }

    public void sendEmail(String email,String sub, String message){

        String[] emailadd = {email};

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL,emailadd);
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        startActivity(Intent.createChooser(intent,"send email"));
    }
}