package com.example.test.lecture13;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

TextView state,source;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      state= (TextView) findViewById(R.id.state);
        source=(TextView)findViewById(R.id.source);

    }
}

