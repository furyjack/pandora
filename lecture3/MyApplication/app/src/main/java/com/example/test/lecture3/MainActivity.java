package com.example.test.lecture3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText Ed1,Ed2;
    private Button btnadd,btnsub,btndiv,btnmul;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("maintag", "onCreate: ");


        Ed1=(EditText)findViewById(R.id.ed1);
        Ed2=(EditText)findViewById(R.id.ed2);

        btnadd=(Button)findViewById(R.id.btna);
        btnsub=(Button)findViewById(R.id.btns);
        btndiv=(Button)findViewById(R.id.btnd);
        btnmul=(Button)findViewById(R.id.btnm);

        result=(TextView)findViewById(R.id.res);


          View.OnClickListener cl=new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  try {
                      int a = Ed1.getText().toString().isEmpty() ? 0 :
                              Integer.parseInt(Ed1.getText().toString());


                      int b = Ed2.getText().toString().isEmpty() ? 0 :
                              Integer.parseInt(Ed2.getText().toString());


                      int c = 0;

                      switch (v.getId()) {

                          case R.id.btna:
                              c = a + b;
                              break;
                          case R.id.btnm:
                              c = a * b;
                              break;
                          case R.id.btns:
                              c = a - b;
                              break;

                          case R.id.btnd:
                              c = a / b;
                              break;


                      }

                result.setText(""+c);

                  }
                  catch (NumberFormatException e)
                  {

                      Toast.makeText(MainActivity.this, "numbers not int", Toast.LENGTH_SHORT).show();
                  }
                  catch(ArithmeticException e)
                  {

                      Toast.makeText(MainActivity.this, "divide by zero", Toast.LENGTH_SHORT).show();
                  }



              }
          };


        btnadd.setOnClickListener(cl);
        btnsub.setOnClickListener(cl);
        btnmul.setOnClickListener(cl);
        btndiv.setOnClickListener(cl);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("maintag", "onpause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("maintag", "onstop: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("maintag", "onresume: ");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("maintag", "ondestroy: ");
    }




}
