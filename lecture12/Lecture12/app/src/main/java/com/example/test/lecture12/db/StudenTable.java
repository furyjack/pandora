package com.example.test.lecture12.db;

public class StudenTable extends DbTable{

    public static final String tb_name="students";

    public interface  Columns
    {
        String ID="id";
        String NAME="name";
        String AGE="age";
        String CLASS="class";

    }


    public static final String TABLE_CREATE_CMD = "CREATE TABLE IF NOT EXISTS " + tb_name
            + LBR + Columns.ID + TYPE_INT_PK + COMMA
            + Columns.NAME + TYPE_TEXT + COMMA
            + Columns.AGE + TYPE_INT + COMMA
            + Columns.CLASS + TYPE_INT
            + RBR + ";";







}
