package com.example.test.lecture6home_work;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_people extends Fragment {
    
    String TAG="myactivity";

    ImageView profile_img;
    String Name;
    int profile_img_id;
    OnCreateViewListner ocvl;

    public View  item=null;
    public Fragment_people() {
        // Required empty public constructor
    }

    public void change_object(String name,int profile_id,String status,String mob_no)
    {
        Log.d(TAG, "change_object: called");
        if(item!=null)
        {
            Name=name;
            profile_img_id=profile_id;
            TextView Tvname = (TextView) item.findViewById(R.id.tv_name);
            TextView Tvstatus = (TextView) item.findViewById(R.id.status);
            TextView Tvmobno = (TextView) item.findViewById(R.id.mob_no);
             profile_img=(ImageView)item.findViewById(R.id.profile_id);
            Tvname.setText(name);
            Tvstatus.setText(status);
            Tvmobno.setText(mob_no);
            profile_img.setImageResource(profile_id);

        }



    }
    public void setOncreateViewListener(OnCreateViewListner listner)
    {
        ocvl=listner;



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
       

        // Inflate the layout for this fragment
        item=inflater.inflate(R.layout.fragment_fragment_people, container, false);
        ocvl.onCreateViewCalled();
        profile_img= (ImageView) item.findViewById(R.id.profile_id);
        final TextView tv=(TextView)item.findViewById(R.id.mob_no);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                String mob=tv.getText().toString();
                Uri no=Uri.parse("tel:"+mob);
                intent.setData(no);
                startActivity(intent);

            }
        });


        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FullScreen", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(),detail_activity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("p",profile_img_id);
                bundle.putString("n",Name);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        return item;
    }

    public interface OnCreateViewListner
    {
        void onCreateViewCalled();

    }

}
