package com.example.trying;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    Context c ;
    public static final String database_name = "database";
    public static final int database_version = 2;

    public DbHelper(Context c){

        super(c , database_name , null , database_version);
        this.c = c ;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table databases("
                + "_id integer primary key autoincrement,"
                + "Consultation varchar(200))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists databases");
        onCreate(sqLiteDatabase);

    }
}
