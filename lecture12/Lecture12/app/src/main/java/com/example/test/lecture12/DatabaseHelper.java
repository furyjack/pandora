package com.example.test.lecture12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.test.lecture12.db.StudenTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String db_name="mydatabase";
    public static final int db_version=1;


   private static DatabaseHelper databaseHelper=null;

    public static SQLiteDatabase openReadableDatabse(Context C)
    {
        if(databaseHelper==null)
        {
            databaseHelper=new DatabaseHelper(C);
        }
        return databaseHelper.getReadableDatabase();


    }
    public static SQLiteDatabase openWriteableDatabse(Context C)
    {
        if(databaseHelper==null)
        {
            databaseHelper=new DatabaseHelper(C);
        }
        return databaseHelper.getWritableDatabase();


    }


    public DatabaseHelper(Context context) {
        super(context, db_name, null,db_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudenTable.TABLE_CREATE_CMD);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
