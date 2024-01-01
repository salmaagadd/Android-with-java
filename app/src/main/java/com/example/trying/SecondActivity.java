package com.example.trying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class SecondActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.Button1);
        registerForContextMenu(btn);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater() ;
        inflater.inflate(R.menu.contextual_menu , menu );

    }

    public void openDialog(){

        dialog dialog = new dialog();
        dialog.show(getSupportFragmentManager() , "dialog");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.name1:
                openDialog();
                return true;

            case R.id.name2:
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }

    public void onClick2(View view){
        startActivity(new Intent("com.example.trying.ThirdActivity"));
    }
}