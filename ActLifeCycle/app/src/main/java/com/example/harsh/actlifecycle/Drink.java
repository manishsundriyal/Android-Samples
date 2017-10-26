package com.example.harsh.actlifecycle;

/**
 * Created by harsh on 10/7/17.
 */

public class Drink {
    int rollNo;
    String description;

    private Drink(int r, String d){
        rollNo=r;
        description= d;
    }

    private static final Drink[] drinks={
        new Drink(1,"Hello"),
        new Drink(2,"world"),
        new Drink(3,"WWW")
    };

    public String getDescription() {
        return description;
    }

    public int getRollNo() {
        return rollNo;
    }
}
