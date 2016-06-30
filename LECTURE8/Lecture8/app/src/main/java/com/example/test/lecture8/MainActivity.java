package com.example.test.lecture8;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=(Button)findViewById(R.id.b);



       final Myloop l=new Myloop();
        final Handler h = new Handler();


        l.setOnLoopDoneListener(new Myloop.LoopDoneListener() {
            @Override
            public void onLoopDone() {



                        Toast.makeText(MainActivity.this, "loop done", Toast.LENGTH_SHORT).show();
                    }


        });

        if (b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    l.doloop(h);
                }
            });
        }

    }

}
