package com.example.test.adapters;

import java.util.ArrayList;

public class COURSES {

    public static class course
    {
        String name;
        int capacity;
        int enrollment;

        public course(String name, int enrollment, int capacity) {
            this.name = name;
            this.enrollment = enrollment;
            this.capacity = capacity;
        }
    }

    public static ArrayList<course> getcourses()
    {
        ArrayList<course> courses=new ArrayList<>(100);
        for(int i=2014;i<2024;i++) {
            courses.add(new course("C++ "+ i, 50, 60));
            courses.add(new course("Java" + i, 50, 70));
            courses.add(new course("PYTHON" + i, 50, 80));
            courses.add(new course("PHP" + i, 50, 90));
            courses.add(new course("Pearl" + i, 50, 600));
            courses.add(new course("Javascript" + i, 50, 750));
            courses.add(new course("Shell" + i, 50, 90));
            courses.add(new course("Basic" + i, 50, 110));
        }

       return courses;

    }

}




