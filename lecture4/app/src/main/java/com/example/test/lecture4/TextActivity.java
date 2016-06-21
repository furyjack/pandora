package com.example.test.lecture4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextActivity extends AppCompatActivity {

    private final String TAG="my_Activty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView tvPageView = (TextView) findViewById(R.id.tv_page_view);
        try {


            Intent coming = getIntent();

            String action=coming.getAction();
            if(action.equals(Intent.ACTION_MAIN)) {


                tvPageView.setText("not opened through share");
                return;
            }
            else if(action.equals(Intent.ACTION_SEND))
            {
                String todisp=coming.getStringExtra(Intent.EXTRA_TEXT);
                tvPageView.setText(todisp);
                return;
            }

            String path=coming.getDataString();

            File text=new File(path);


            FileInputStream fis = null;
            try {
                fis = new FileInputStream (new File(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }





    }
}
