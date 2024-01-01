package com.example.trying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu , menu);
        return true ;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item1:
                startActivity(new Intent(this , SettingsActivity.class));
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void onClick1(View view){
        startActivity(new Intent("com.example.trying.SecondActivity"));

        EditText editTextName=findViewById(R.id.editTextPersonName);
        EditText editTextAge=findViewById(R.id.editTextAge);
        EditText editTextPhone=findViewById(R.id.editTextPhone);
        RadioButton radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        RadioButton radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);
        String gender="";
        if (radioButtonMale.isChecked()){
            gender="Male";
        }
        else {
            gender="Female";
        }
        String nameValue=editTextName.getText().toString();
        String ageValue=editTextAge.getText().toString();
        String phoneValue=editTextPhone.getText().toString();

        SharedPreferences preferences=getApplicationContext().getSharedPreferences( "com.example.trying", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("Name",nameValue);
        editor.putString("Age",ageValue);
        editor.putString("Phone",phoneValue);
        editor.putString("Gender",gender);

        editor.commit();

    }



    }