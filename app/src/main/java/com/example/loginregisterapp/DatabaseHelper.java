package com.example.loginregisterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDB";
    private static final int DATABASE_VERSION = 2; // Increment version on schema changes
    private static final String TABLE_NAME = "users";
    private static final String COL_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); // Use DATABASE_VERSION
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USERNAME + " TEXT UNIQUE, " + // Added UNIQUE constraint
                COL_PASSWORD + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) { //Example upgrade, change version number accordingly
            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN new_column TEXT;"); //Example of adding a column
        }
        //This is the recommended way to handle schema changes.
    }

    public boolean registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, username);
        values.put(COL_PASSWORD, password);

        try {
            long result = db.insertOrThrow(TABLE_NAME, null, values); // Use insertOrThrow
            return result != -1; // Returns true if registration is successful
        } catch (android.database.SQLException e) {
            // Handle unique constraint violation or other errors
            return false; // Return false if registration fails
        } finally {
            db.close();
        }
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL_USERNAME + "=? AND " + COL_PASSWORD + "=?", new String[]{username, password});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists; // Returns true if user exists
    }
}