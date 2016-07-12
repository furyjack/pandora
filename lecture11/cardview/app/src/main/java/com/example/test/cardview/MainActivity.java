package com.example.test.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView Rvmain;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
        Rvmain=(RecyclerView)findViewById(R.id.rv_main);
        RecyclerView.LayoutManager mngr=new LinearLayoutManager(this);
        Rvmain.setLayoutManager(mngr);
        EventAdapter adp=new EventAdapter();

        Rvmain.setAdapter(adp);
        adp.notifyDataSetChanged();




    }


    public class EventViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView type;
        TextView topic;


        public EventViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tv_name);
            type=(TextView)itemView.findViewById(R.id.tv_type);
            topic=(TextView)itemView.findViewById(R.id.tv_topic);
        }
    }

    public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>
    {


        @Override
        public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemview=getLayoutInflater().inflate(R.layout.listitem_card,parent,false);
            EventViewHolder holder=new EventViewHolder(itemview);


            return holder;
        }

        @Override
        public void onBindViewHolder(final EventViewHolder holder, int position) {

            StringRequest request=new StringRequest(Request.Method.GET, "http://open-event.herokuapp.com/api/v2/events/" + (position + 3), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    JSONObject obj;
                    try {
                         obj=new JSONObject(response);
                    } catch (JSONException e) {
                        obj=null;
                        e.printStackTrace();
                    }
                    String name="Not found";
                    String type="Not found";
                    String topic="Not found";
                    if(obj!=null)
                    {
                        try{
                         name=obj.getString("name");
                        type=obj.getString("type");

                            topic=obj.getString("topic");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    holder.name.setText(name);
                    holder.topic.setText(topic);
                    holder.type.setText(type);




                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    int code=-1;
                    if(error!=null && error.networkResponse!=null)
                     code=error.networkResponse.statusCode;

                    String err;
                    if(code==-1)
                        err="No internet";
                    else
                       err=""+code;
                    holder.name.setText("Error code : "+err);
                    holder.topic.setText("Error code : "+err);
                    holder.type.setText("Error code : "+err);





                }
            });


          queue.add(request);
        }

        @Override
        public int getItemCount() {
            return 7;
        }
    }




}
