package com.example.test.lecture12.models;


public class student {
    int id;
    String name;
    int studentclass;
    int age;

    public student(int id, String name, int studentclass, int age) {
        this.id = id;
        this.name = name;
        this.studentclass = studentclass;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudentclass() {
        return studentclass;
    }

    public int getAge() {
        return age;
    }
}
