package com.example.test.lecture6home_work;

import java.util.ArrayList;

public class People {

    public static  class people
    {
        int profileimg_id;
        String name;
        String status;
        String mob_no;


        public people(int profileimg_id, String name, String status, String mob_no) {
            this.profileimg_id = profileimg_id;
            this.name = name;
            this.status = status;
            this.mob_no = mob_no;

        }
    }

       public static     ArrayList<people> getPeople()
       {
         ArrayList<people>  items=new ArrayList<>(10);
        items.add(new people(R.drawable.sample_0,"Deeksha","The ones who are dead shall never die","9910677443"));
        items.add(new people(R.drawable.sample_1,"Lakshay","GAME ON!","9910531883"));
        items.add(new people(R.drawable.sample_2,"Palak","Busy ,Please Dont Disturb","9910031383"));
        items.add(new people(R.drawable.sample_6,"Suri","Sleeping all day long","9977442221"));
        items.add(new people(R.drawable.sample_4,"Luv","Carpe diem! Living my life","9910535432"));
        items.add(new people(R.drawable.sample_5,"Saurav","You cant see me!!!!","9910531883"));
        items.add(new people(R.drawable.sample_6,"Navjot","The ones who are dead shall never die","9910781883"));
        items.add(new people(R.drawable.sample_7,"Isha","Busy ,Please Dont Disturb","9910531867"));
        items.add(new people(R.drawable.sample_1,"Jaini","The ones who are dead shall never die","9914561883"));
        items.add(new people(R.drawable.sample_4,"Shubhra","Busy ,Please Dont Disturb","9910007787"));

        return items;






    }


}
