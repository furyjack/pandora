package com.example.test.lecture12;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.test.lecture12.db.StudenTable;
import com.example.test.lecture12.models.student;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SQLiteDatabase mydb=DatabaseHelper.openWriteableDatabse(this);
        student stu=new student(3,"johny",5,11);
        ContentValues values=new ContentValues();
        values.put(StudenTable.Columns.ID,stu.getId());
        values.put(StudenTable.Columns.NAME,stu.getName());
        values.put(StudenTable.Columns.AGE,stu.getAge());
        values.put(StudenTable.Columns.CLASS,stu.getStudentclass());

        mydb.insert(StudenTable.tb_name,null,values);

        String projection[]={StudenTable.Columns.ID,StudenTable.Columns.NAME};
        String sel[]={"3"};

        Cursor c=mydb.query(StudenTable.tb_name,projection,null,null,null,null,null);
        Log.d(TAG, ""+c.getCount());
        while(c.moveToNext()) {

            int stuid = c.getInt(c.getColumnIndex(StudenTable.Columns.ID));
            String stuname = c.getString(c.getColumnIndex(StudenTable.Columns.NAME));

            Log.d(TAG, "" + stuid);
            Log.d(TAG, stuname);


        }




    }
}
