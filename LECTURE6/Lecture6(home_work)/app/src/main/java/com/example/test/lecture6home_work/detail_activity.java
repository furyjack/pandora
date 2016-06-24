package com.example.test.lecture6home_work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detail_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);
        Bundle bundle=getIntent().getExtras();
        TextView tvn=(TextView)findViewById(R.id.tv_d_name);
        ImageView imageView=(ImageView)findViewById(R.id.profile);
        imageView.setImageResource(bundle.getInt("p"));
        tvn.setText(bundle.getString("n"));

    }
}
