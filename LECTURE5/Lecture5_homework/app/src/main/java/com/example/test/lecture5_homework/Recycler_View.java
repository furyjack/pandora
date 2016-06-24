package com.example.test.lecture5_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Recycler_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__view);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_students);
        ArrayList<Students.student> students=Students.getStudent();
        StudentViewAdapter studentViewAdapter=new StudentViewAdapter(students);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(studentViewAdapter);
        studentViewAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


        Toast.makeText(Recycler_View.this, "Recycler View", Toast.LENGTH_LONG).show();
    }



   public class StudentViewHolder extends RecyclerView.ViewHolder
   {
       public TextView name;
       public TextView roll;
       public ImageView profile;

       public StudentViewHolder(View itemView) {
           super(itemView);
           this.name = (TextView)itemView.findViewById(R.id.tv_name);
           this.roll = (TextView)itemView.findViewById(R.id.tv_roll);
           this.profile = (ImageView)itemView.findViewById(R.id.iv_profile);

       }



   }


    public class StudentViewAdapter extends RecyclerView.Adapter<StudentViewHolder>
    {
        ArrayList<Students.student> mlist;

        public StudentViewAdapter(ArrayList<Students.student> mlist) {
            this.mlist = mlist;
        }

        @Override
        public int getItemViewType(int position) {

            if(position%2==0)
                return 1;
            else
               return 0;



        }

        @Override
        public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater=getLayoutInflater();
            View itemview;
            StudentViewHolder viewHolder;
            if(viewType==1)
            {
                itemview=inflater.inflate(R.layout.student_list_item_left,parent, false);
                viewHolder=new StudentViewHolder(itemview);


            }
            else
            {
                itemview=inflater.inflate(R.layout.student_list_item_right,parent,false);
                viewHolder=new StudentViewHolder(itemview);

            }


            viewHolder.name=(TextView)itemview.findViewById(R.id.tv_name);
            viewHolder.roll=(TextView)itemview.findViewById(R.id.tv_roll);
            viewHolder.profile=(ImageView) itemview.findViewById(R.id.iv_profile);


            return viewHolder;





        }

        @Override
        public void onBindViewHolder(StudentViewHolder holder, int position) {



            Students.student myobject=mlist.get(position);
            holder.profile.setImageDrawable(getDrawable(myobject.profile));
            holder.name.setText(myobject.name);
            holder.roll.setText(""+myobject.roll_no);


        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }





}
