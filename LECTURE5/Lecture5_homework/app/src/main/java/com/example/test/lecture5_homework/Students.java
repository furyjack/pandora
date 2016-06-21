package com.example.test.lecture5_homework;


import java.util.ArrayList;

public class Students {

    public static  class student
    {
        public String name;
        public int roll_no;
        public int  profile;

        public student(String name, int roll_no, int profile) {
            this.name = name;
            this.roll_no = roll_no;
            this.profile = profile;
        }




    }


public static ArrayList<student> getStudent()
{
    ArrayList<student> students=new ArrayList<>(10);
    students.add(new student("Lakshay",35,R.drawable.sample_0));
    students.add(new student("Lakshit",36,R.drawable.sample_0));
    students.add(new student("Kunal",37,R.drawable.sample_0));
    students.add(new student("Kushagra",38,R.drawable.sample_0));
    students.add(new student("Palak",39,R.drawable.sample_0));
    students.add(new student("Deeksha",40,R.drawable.sample_0));
    students.add(new student("Isha",45,R.drawable.sample_0));
    students.add(new student("Nisith",55,R.drawable.sample_0));
    students.add(new student("Suri",25,R.drawable.sample_0));
    students.add(new student("Navjot",15,R.drawable.sample_0));


    return  students;





}



}
