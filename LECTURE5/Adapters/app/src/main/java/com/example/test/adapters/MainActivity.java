package com.example.test.adapters;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<COURSES.course> courselist;
    ListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courselist=COURSES.getcourses();
        courseListView=(ListView)findViewById(R.id.list_view);

        courseListView.setAdapter(new CourseListAdapter(courselist));



    }


    private class CourseListAdapter extends BaseAdapter
    {

        public final static String tag="Logs";
        class CourseViewHolder
        {
            public TextView courseNameView;
           public  TextView courseStrengthView;

        }



       private ArrayList<COURSES.course> mcourses;

        public CourseListAdapter(ArrayList<COURSES.course> mcourses) {
            this.mcourses = mcourses;
        }

        @Override
        public int getCount() {
            return mcourses.size();
        }

        @Override
        public COURSES.course getItem(int position) {
            return mcourses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Log.d(tag, "getView: ");
            LayoutInflater li= getLayoutInflater();
            CourseViewHolder courseViewHolder;

            if(convertView==null) {
                Log.d(tag, "null ");
                convertView = li.inflate(R.layout.list_item_course, null);

                courseViewHolder = new CourseViewHolder();
                courseViewHolder.courseNameView=(TextView)convertView.findViewById(R.id.tv_course_name);
                courseViewHolder.courseStrengthView=(TextView)convertView.findViewById(R.id.tv_course_perc);

                convertView.setTag(courseViewHolder);

            }
            else

            {
                Log.d(tag, "not null: ");
                courseViewHolder=(CourseViewHolder)convertView.getTag();

            }


            COURSES.course ThisCourse=getItem(position);

            courseViewHolder.courseNameView.setText(ThisCourse.name);
            double strengthPerc=((float)ThisCourse.enrollment/(float)ThisCourse.capacity)*100;


            courseViewHolder.courseStrengthView.setText(String.valueOf(strengthPerc));
            if(strengthPerc>50)
               courseViewHolder.courseStrengthView.setTextColor(Color.GREEN);
            else
               courseViewHolder.courseStrengthView.setTextColor( Color.RED );
            return convertView;
        }
    }


}
