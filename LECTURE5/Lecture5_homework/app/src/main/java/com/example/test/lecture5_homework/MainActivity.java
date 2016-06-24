package com.example.test.lecture5_homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvStudents=(ListView)findViewById(R.id.lv_students);
        final ArrayList<Students.student> list=Students.getStudent();
        studentAdapter studentAdapter=new studentAdapter(list);
        if (lvStudents != null) {
            lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(MainActivity.this, list.get(position).name, Toast.LENGTH_SHORT).show();
                    String name=list.get(position+1).name;
                    TextView n=(TextView)view.findViewById(R.id.tv_name);
                    n.setText(name);


                 }
            });
            lvStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0)
                    {
                        Intent intent=new Intent(getApplicationContext(),Recycler_View.class);
                        startActivity(intent);




                    }



                    return false;
                }
            });
        }

        lvStudents.setAdapter(studentAdapter);





    }



    public class studentAdapter extends BaseAdapter
    {
        public final String TAG="mainacivity";

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            Log.d(TAG, "position = " + position);
            if(position%2==0)
                return 0;
            else
                return 1;

        }

        class StudentViewHolder
        {
            public TextView name;
            public TextView roll;
            public ImageView profile;



        }
        ArrayList<Students.student> mlist;

        public studentAdapter(ArrayList<Students.student> mlist) {
            this.mlist = mlist;
        }


        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Students.student getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            StudentViewHolder studentViewHolder;
            Log.d(TAG, "getView: ");
            Log.d(TAG, "getView:  itemViewType =" + getItemViewType(position) + " position = " + position);
            if(convertView==null || getItemViewType(position)!=(position%2))
            {
                Log.d(TAG, "convertview==null ");
                if(position%2==0)
                    convertView=inflater.inflate(R.layout.student_list_item_left,parent,false);
                else
                    convertView=inflater.inflate(R.layout.student_list_item_right,parent,false);

                studentViewHolder=new StudentViewHolder();
                studentViewHolder.name=(TextView)convertView.findViewById(R.id.tv_name);
                studentViewHolder.roll=(TextView)convertView.findViewById(R.id.tv_roll);
                studentViewHolder.profile=(ImageView) convertView.findViewById(R.id.iv_profile);



                convertView.setTag(studentViewHolder);






            }
            else
            {

                Log.d(TAG, "convertview!=null");
                studentViewHolder=(StudentViewHolder)convertView.getTag();


            }


            Students.student myobject=getItem(position);
            studentViewHolder.profile.setImageDrawable(getDrawable(myobject.profile));
            studentViewHolder.name.setText(myobject.name);
            studentViewHolder.roll.setText(""+myobject.roll_no);


            return convertView;
        }
    }




}
