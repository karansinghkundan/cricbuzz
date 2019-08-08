package com.example.cricbuzzz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "dbStudent";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

        String userTable = "CREATE TABLE " + DBUser.TABLE_NAME
                + "(" + DBUser.EMAIL + " TEXT PRIMARY KEY,"
                + DBUser.PASSWORD + " TEXT)";

        sqLiteDatabase.execSQL(userTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL("DROP TABLE " + DBUser.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}