package com.example.cricbuzzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBUser
{
    public static final String TABLE_NAME = "tblUser";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    private DBHelper dbHelper;

    public DBUser(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void insert(User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(EMAIL, user.getEmail());
        cv.put(PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null,cv);

        db.close();

    }
    public void update(User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(EMAIL, user.getEmail());
        cv.put(PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null,cv);
        db.update(TABLE_NAME,cv,
                EMAIL + "=?",
                new String[]
                        {
                                String.valueOf(user.getEmail())
                        });
        db.close();
    }

    public void deleteByEmail(String userEmail)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, EMAIL + "=?",
                new String[]
                        {
                                userEmail
                        });
        db.close();
    }

    public ArrayList<User> getAllStudent()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //Cursor mCursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<User > mUsers = new ArrayList<>();
        if(mCursor != null)
        {
            if(mCursor.getCount() != 0)
            {
                mCursor.moveToFirst();
                while (!mCursor.isAfterLast())
                {
                    User mUser = new User();
                    mUser.setEmail(mCursor.getString(0));
                    mUser.setPassword(mCursor.getString(1));

                    mUsers.add(mUser);

                    mCursor.moveToNext();
                }
            }
        }

        db.close();
        return mUsers;
    }

    public ArrayList<User> getStudentByEmail(String studentEmail)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor mCursor = db.query(TABLE_NAME, null, EMAIL + "=?", new String[]{String.valueOf(studentEmail)}, null, null, null, null);


        ArrayList<User> mUsers = new ArrayList<>();
        if(mCursor != null)
        {
            if(mCursor.getCount() != 0)
            {
                mCursor.moveToFirst();
                while (!mCursor.isAfterLast())
                {
                    User mUser = new User();
                    mUser.setEmail(mCursor.getString(0));
                    mUser.setPassword(mCursor.getString(1));

                    mUsers.add(mUser);

                    mCursor.moveToNext();
                }
            }
        }

        db.close();
        return mUsers;
    }

}
