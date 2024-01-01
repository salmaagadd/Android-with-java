package com.example.trying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    EditText etMessage;
    DbHelper helper;
    final private int REQUEST_SEND_SMS =123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etMessage=findViewById(R.id.et_message);
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    REQUEST_SEND_SMS);
        }

        helper = new DbHelper(getApplicationContext());

    }
    @Override

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_SEND_SMS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(ThirdActivity.this,
                            "SEND Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ThirdActivity.this,"SEND Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode,
                        permissions, grantResults);
        }
    }

        public void onClick(View view) {
            String sMessage = etMessage.getText().toString().trim();
            SharedPreferences preferences=getSharedPreferences("com.example.trying", Context.MODE_PRIVATE);
            String name=preferences.getString("Name","no name");
            String age=preferences.getString("Age","no age");
            String phone=preferences.getString("Phone","no phone");
            String gender=preferences.getString("Gender","no gender");
            sendSMS("5554", sMessage,name,age,phone,gender);

            EditText et_message = findViewById(R.id.et_message);
            String message = et_message.getText().toString();
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Consultation" , message);
            db.insert("databases" , null , values);
        }


    private void sendSMS (String phoneNumber, String message,String Name,String Age,String Phone,String Gender) {
        String sMessage = etMessage.getText().toString().trim();
        SharedPreferences preferences=getSharedPreferences("com.example.trying", Context.MODE_PRIVATE);
        String name=preferences.getString("Name","no name");
        String age=preferences.getString("Age","no age");
        String phone=preferences.getString("Phone","no phone");
        String gender=preferences.getString("Gender","no gender");


        if (!sMessage.equals("")) {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, "Name:"+Name, null, null);
            sms.sendTextMessage(phoneNumber, null, "Age:"+Age, null, null);
            sms.sendTextMessage(phoneNumber, null, "Phone:"+Phone, null, null);
            sms.sendTextMessage(phoneNumber, null, "Gender:"+Gender, null, null);
            sms.sendTextMessage(phoneNumber, null, "MyConsultation:"+message, null, null);
        } else {
            Toast.makeText(ThirdActivity.this,"Enter Message First",Toast.LENGTH_SHORT).show();
        }
    }


    public void select(View v){

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.query("databases" , null , null , null
                ,null , null , null);

        String data = "";
        while (c.moveToNext()){

            int _id = c.getInt(c.getColumnIndexOrThrow("_id"));
            String message = c.getString(c.getColumnIndexOrThrow("Consultation"));
            String row = _id + "," + message + "\n";
            data = data + row;

        }
        Toast t = Toast.makeText(this , data , Toast.LENGTH_LONG);
        t.show();
    }


}