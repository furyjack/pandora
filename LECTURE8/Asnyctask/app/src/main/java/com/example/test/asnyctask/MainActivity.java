package com.example.test.asnyctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton=(Button)findViewById(R.id.click);
        final  MyTask[] task={new MyTask(getApplicationContext())};

        if (myButton != null) {
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(task[0].getStatus()!= AsyncTask.Status.RUNNING && task[0].getStatus()!= AsyncTask.Status.FINISHED) {
                        task[0].execute();
                        Toast.makeText(MainActivity.this, "Task Started", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(task[0].getStatus()== AsyncTask.Status.RUNNING)
                            Toast.makeText(MainActivity.this, "Task running", Toast.LENGTH_SHORT).show();
                        else {
                             task[0] = new MyTask(getApplicationContext());
                            task[0].execute();
                            Toast.makeText(MainActivity.this, "Task Started", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });
        }

    }
}
