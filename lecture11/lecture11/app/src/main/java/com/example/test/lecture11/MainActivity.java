package com.example.test.lecture11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    RequestQueue queue;
    ImageView Tvresult;
    Button btndown;
    EditText etSelect;

    public StringRequest StringRequestBuilder(String event_id)
    {
        String url="http://open-event.herokuapp.com/api/v2/events/"+event_id;
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject obj= null;
                try {
                    obj = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String poster_path="";
                try {
                    if (obj != null) {
                        poster_path=obj.getString("logo");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
               if(!poster_path.equals(""))
                Picasso.with(getApplicationContext()).load(poster_path).into(Tvresult);
            }
        },new Response.ErrorListener()
        {


            @Override
            public void onErrorResponse(VolleyError error) {

                if(error.getCause()!=null)
                {
                    error.printStackTrace();
                }
                if(error.networkResponse!=null)
                {
                    Toast.makeText(MainActivity.this, "request code:"+ error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
                }

            }
        });


return stringRequest;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        Tvresult=(ImageView) findViewById(R.id.tv1);

        btndown=(Button)findViewById(R.id.btn_down) ;
        etSelect=(EditText)findViewById(R.id.et_select);

        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=etSelect.getText().toString();
                StringRequest req=StringRequestBuilder(id);
                queue.add(req);
            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences spref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed =spref.edit();
        String evid;
        try
        {
            evid=etSelect.getText().toString();
        }catch (Exception e) {
            evid = "4";
        }

        ed.putString("eveny_id",evid);
        ed.apply();



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref=getPreferences(MODE_PRIVATE);
        String evId=pref.getString("eveny_id","-1");
        etSelect.setText(evId);
        queue.add(StringRequestBuilder(evId));

    }
}
