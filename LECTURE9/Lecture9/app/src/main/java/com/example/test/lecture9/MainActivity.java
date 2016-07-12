package com.example.test.lecture9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnstart,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.start);
        btnstop= (Button) findViewById(R.id.stop);
        final Intent si=new Intent(this,MyIntentService.class);
        si.setAction(MyIntentService.ACTION_FOO);


        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.start:
                    {
                        startService(si);
                    }
                        break;
                    case R.id.stop:
                        stopService(si);
                        break;



                }


            }
        };


       btnstart.setOnClickListener(listener);
        btnstop.setOnClickListener(listener);

    }
}
