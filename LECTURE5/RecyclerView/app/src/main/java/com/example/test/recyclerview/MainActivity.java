package com.example.test.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_view);
        ArrayList<COURSES.course> arrayList=new ArrayList<>(COURSES.getcourses());

        CourseRecyclerViewAdapter courseRecyclerViewAdapter=new CourseRecyclerViewAdapter(arrayList);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(courseRecyclerViewAdapter);

        courseRecyclerViewAdapter.notifyDataSetChanged();



    }


    public class CourseRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView courseNameView;
        public  TextView courseStrengthView;

        public CourseRecyclerViewHolder(View itemView) {
            super(itemView);
            courseNameView=(TextView)itemView.findViewById(R.id.tv_course_name);
            courseStrengthView=(TextView)itemView.findViewById(R.id.tv_course_perc);
        }
    }


    public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewHolder> {


        private ArrayList<COURSES.course> mcourses;

        public CourseRecyclerViewAdapter(ArrayList<COURSES.course> mcourses) {

            this.mcourses = mcourses;
        }


        @Override
        public CourseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li=getLayoutInflater();
            View itemView=li.inflate(R.layout.list_item_course,null);

            CourseRecyclerViewHolder courseRecyclerViewHolder=new CourseRecyclerViewHolder(itemView);
            return  courseRecyclerViewHolder;


        }

        @Override
        public void onBindViewHolder(CourseRecyclerViewHolder holder, int position) {

          COURSES.course thiscourse=mcourses.get(position);

            holder.courseNameView.setText(thiscourse.name);
            holder.courseStrengthView.setText(String.valueOf((float)thiscourse.enrollment/(float)thiscourse.capacity));







        }

        @Override
        public int getItemCount() {
            return mcourses.size();
        }


    }
}

