package com.example.test.lecture5_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                }
            });
        }

        lvStudents.setAdapter(studentAdapter);





    }


    public class studentAdapter extends BaseAdapter
    {
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
            if(position%2==0)
            convertView=inflater.inflate(R.layout.student_list_item_left,null);
            else
                convertView=inflater.inflate(R.layout.student_list_item_right,null);

            ImageView profile=(ImageView)convertView.findViewById(R.id.iv_profile);
            TextView name=(TextView)convertView.findViewById(R.id.tv_name);
            TextView roll=(TextView)convertView.findViewById(R.id.tv_roll);

            Students.student myobject=getItem(position);
            profile.setImageDrawable(getDrawable(myobject.profile));
            name.setText(myobject.name);
            roll.setText(""+myobject.roll_no);


            return convertView;
        }
    }




}
