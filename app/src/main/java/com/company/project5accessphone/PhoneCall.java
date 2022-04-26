package com.company.project5accessphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneCall extends AppCompatActivity {

    EditText phonenumer;
    Button phonebutton;
    String phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Phone Call");
        setContentView(R.layout.activity_phone_call);

        phonebutton= findViewById(R.id.phonecallbtn);
        phonenumer= findViewById(R.id.phonenumber);

        phonebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                phonenumber = phonenumer.getText().toString();

                phoncecall(phonenumber);
            }
        });





    }
    public void phoncecall(String number){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.CALL_PHONE
            },1);
        }else{
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }

    }
}