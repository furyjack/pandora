package com.example.test.lecture6home_work;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    public RecyclerView recyclerView=null;
    public ArrayList<People.people> students;
    Fragment_people fragment_people;
    public void setRecyclerView()
    {
         recyclerView=(RecyclerView)findViewById(R.id.rv_main);
         students=People.getPeople();
        PeopleViewAdapter peopleViewAdapter=new PeopleViewAdapter(students);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(peopleViewAdapter);
        peopleViewAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


    }

    public void setFragment()
    {

        final FragmentManager fragMgr = getSupportFragmentManager();
        fragment_people=new Fragment_people();
        People.people object=students.get(0);

        fragMgr.beginTransaction().add(R.id.fl_main,fragment_people,null).commit();





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();


        setFragment();
        fragment_people.setOncreateViewListener(new Fragment_people.OnCreateViewListner() {
            @Override
            public void onCreateViewCalled() {
                People.people object = students.get(0);
                fragment_people.change_object(object.name,object.profileimg_id,object.status,object.mob_no);
            }
        });



    }


    public class PeopleViewHolder extends RecyclerView.ViewHolder
    {


        public ImageView profile;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            this.profile = (ImageView)itemView.findViewById(R.id.iv_listitem);

        }



    }


    public class PeopleViewAdapter extends RecyclerView.Adapter<PeopleViewHolder>
    {
        ArrayList<People.people> mlist;

        public PeopleViewAdapter(ArrayList<People.people> mlist) {
            this.mlist = mlist;
        }



        @Override
        public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater=getLayoutInflater();
            View itemview;
            PeopleViewHolder viewHolder;
            itemview=inflater.inflate(R.layout.list_item_view,parent,false);
            viewHolder=new PeopleViewHolder(itemview);


            viewHolder.profile=(ImageView) itemview.findViewById(R.id.iv_listitem);


            return viewHolder;





        }

        @Override
        public void onBindViewHolder(final PeopleViewHolder holder, final int position) {



            People.people myobject=mlist.get(position);
            holder.profile.setImageDrawable(getDrawable(myobject.profileimg_id));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int pos=holder.getAdapterPosition();
                    People.people object=students.get(pos);
                    Toast.makeText(MainActivity.this, object.name, Toast.LENGTH_SHORT).show();

                    fragment_people.change_object(object.name,object.profileimg_id,object.status,object.mob_no);


                }
            });


        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

    }





}




