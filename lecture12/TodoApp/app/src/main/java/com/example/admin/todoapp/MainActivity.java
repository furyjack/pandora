package com.example.admin.todoapp;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.todoapp.DB.TaskTable;
import com.example.admin.todoapp.models.TaskModel;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="logs";
    ImageButton datepicker,btnAddTask;
    int myear,mmonth,mday;
    RecyclerView tasklist;
    EditText etAddTask;
    SQLiteDatabase mDB;
    ArrayList<TaskModel>tasks;
    TaskAdapter Adapter;



    public void setdate(View v)
    {

        final Calendar c = Calendar.getInstance();
       int mYear = c.get(Calendar.YEAR);
      final int  mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myear=year;
                mmonth=monthOfYear;
                mday=dayOfMonth;

                Toast.makeText(MainActivity.this, "year: "+myear + " month: "+mmonth+" day: "+mday, Toast.LENGTH_SHORT).show();
            }
        },mYear,mMonth,mDay);

        dialog.show();

    }

    public void initialize_components()
    {
        datepicker=(ImageButton)findViewById(R.id.date_select);
        tasklist=(RecyclerView)findViewById(R.id.rv_tasks);
        etAddTask=(EditText)findViewById(R.id.et_task_add);
        Calendar c=Calendar.getInstance();
        myear=c.get(Calendar.YEAR);
        mmonth=c.get(Calendar.MONTH);
        mday=c.get(Calendar.DAY_OF_MONTH);
        tasks=new ArrayList<>();





    }

    public void update_database(View v)
    {

        String task_name=etAddTask.getText().toString();
        if(task_name.equals("")) {
            Toast.makeText(MainActivity.this, "Please enter a task ", Toast.LENGTH_SHORT).show();
            return;
        }
        task_name=task_name.substring(0,1).toUpperCase()+task_name.substring(1);

        TaskModel newtask=new TaskModel(task_name,""+mday+"-"+mmonth+"-"+myear);
        ContentValues value=new ContentValues();
        value.put(TaskTable.Columns.NAME,newtask.getName());
        value.put(TaskTable.Columns.DEADLINE,newtask.getDeadline());
        value.put(TaskTable.Columns.DONE,newtask.isDone());
        Toast.makeText(MainActivity.this, ""+mDB.insert(TaskTable.tb_name,null,value), Toast.LENGTH_SHORT).show();
        tasks.add(newtask);
        Adapter.notifyDataSetChanged();






    }

    public void set_recyclerview()
    {


     Adapter=new TaskAdapter(tasks);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        tasklist.setLayoutManager(layoutManager);

        tasklist.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();






    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize_components();
        mDB=DatabaseCreator.openWriteableDatabse(this);
        mDB.delete(TaskTable.tb_name, null, null);
        set_recyclerview();



 //       SQLiteDatabase mDB=DatabaseCreator.openWriteableDatabse(this);
//        ArrayList<TaskModel> tasks= Utils.getTasks();
//        mDB.delete(TaskTable.tb_name, null, null);
//        //write tasks to db
//
//        for(int i=0;i<tasks.size();i++)
//       {
//           ContentValues values=new ContentValues();
//           values.put(TaskTable.Columns.NAME,tasks.get(i).getName());
//           values.put(TaskTable.Columns.DEADLINE,tasks.get(i).getDeadline());
//           values.put(TaskTable.Columns.DONE,tasks.get(i).isDone());
//
//           tasks.get(i).setId( mDB.insert(TaskTable.tb_name,null,values));
//
//       }
//
//        Cursor c=mDB.query(TaskTable.tb_name,TaskTable.projection,null,null,null,null,null);
//
//        Log.d(TAG, "database size = " + c.getCount());
//
//        while(c.moveToNext())
//        {
//
//
//            Log.d(TAG, "ID = "+ c.getInt(c.getColumnIndex(TaskTable.Columns.ID))+"\n");
//            Log.d(TAG, "NAME = "+ c.getString(c.getColumnIndex(TaskTable.Columns.NAME))+"\n");
//            Log.d(TAG, "DEADLINE = "+ c.getString(c.getColumnIndex(TaskTable.Columns.DEADLINE))+"\n");
//            Log.d(TAG, "DONE = "+ c.getInt(c.getColumnIndex(TaskTable.Columns.DONE))+"\n");
//
//
//
//
//        }
//
//
//
//
//
//
//



    }


    public class TaskViewHolder extends RecyclerView.ViewHolder
    {
        TextView task_name,task_date;


        public TaskViewHolder(View itemView) {
            super(itemView);
            task_name= (TextView) itemView.findViewById(R.id.tv_li_name);
            task_date=(TextView)itemView.findViewById(R.id.tv_li_date);
        }
    }


    public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>
    {
        ArrayList<TaskModel> mlist;

        public TaskAdapter(ArrayList<TaskModel> mlist) {
            this.mlist = mlist;
        }

        @Override
        public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View Itemview=getLayoutInflater().inflate(R.layout.task_list_item,parent,false);
            TaskViewHolder holder=new TaskViewHolder(Itemview);

            return holder;


        }

        @Override
        public void onBindViewHolder(TaskViewHolder holder, int position) {

          TaskModel task=mlist.get(position);
            holder.task_name.setText(task.getName());
            holder.task_date.setText(task.getDeadline());


        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }





}
