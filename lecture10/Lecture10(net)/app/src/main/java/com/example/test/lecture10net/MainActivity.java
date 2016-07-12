package com.example.test.lecture10net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvname;
    TextView tvdate;
    TextView tvType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload=(Button)findViewById(R.id.btn_download);
         tvname=(TextView)findViewById(R.id.tv_name);
        tvdate=(TextView)findViewById(R.id.tv_date);
        tvType=(TextView)findViewById(R.id.tv_type);
        if (btnDownload != null) {
            btnDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    check_connection();
                }
            });
        }


    }

    public void check_connection()
    {
        ConnectivityManager cmgr=(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netinfo=cmgr.getActiveNetworkInfo();
        if(netinfo!=null && netinfo.isConnected())
        {

            NetFetchTask task= (NetFetchTask) new NetFetchTask(new NetFetchTask.onPostExecuteDoneListener() {
                @Override
                 public void onPostExecuteDone(String a) {
                    try {
                        JSONObject root = new JSONObject(a);
                        String name = root.getString("name");
                        String date = root.getString("start_time");
                        String typr = root.getString("type");

                        tvname.setText(name);
                        tvdate.setText(date);
                        tvType.setText(typr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }).execute("http://open-event.herokuapp.com/api/v2/events/4");






        }
        else
            Toast.makeText(MainActivity.this, "NO net connection", Toast.LENGTH_SHORT).show();


    }
}
