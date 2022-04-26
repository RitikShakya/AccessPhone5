package com.company.project5accessphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessage extends AppCompatActivity {


    EditText entermessage, enternumber;

    Button sendmesg;
    String phonenumber;
    String usermessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Send Message");
        setContentView(R.layout.activity_send_message);

                entermessage =findViewById(R.id.textmesg);
                enternumber =findViewById(R.id.phonenumbermesg);

                sendmesg = findViewById(R.id.SendMessage);

                sendmesg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                         usermessage =entermessage.getText().toString();
                         phonenumber = enternumber.getText().toString();

                         sendMessage(usermessage,phonenumber);
                    }
                });
    }

    public void sendMessage(String usermessage, String phonenumber){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS},1);

        }else{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber,null,usermessage,null,null);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1&&permissions.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber,null,usermessage,null,null);

        }
    }
}