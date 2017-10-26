package com.example.acer.myapplication.Com;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class comm {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final comm[] drinks = { new comm("Company Secretaries deal with legal aspects in the management of a company. They keep company's records; complete tax returns; advice the Board of Directors.",R.drawable.cs,"2-8lakhs","Commerce"),
            new comm("Financial Planners confer with clients, assess their financial resources, and offer financial plans to them to help them achieve their lifelong financial goals",R.drawable.fp,"1.99 Lakh to 9.81 Lakhs per annum","Maths")
            ,new comm("Media planners and buyers are people who work to find the right medium for advertising a product and buy space for the ad.",R.drawable.mp,"96 Thousand to 1.17 Lakh per annum","Maths")
           ,new comm("Big data analysts help organizations harness and use data to plan business strategies, improve operational efficiency, identify new opportunities and generate higher profits",R.drawable.bd," 1 Lakh to 6.93 Lakhs per annum","Mathematics"),
            new comm("Chartered Accountants deal with the management of money and provide financial advice. They maintain records of financial transactions which every organisation is required to keep by law and also carry out company audits.",R.drawable.caa,"2.93 Lakhs to 15.18 Lakhs per annum","maths,science,accounts")
            };





    //Each Drink has a name, description, and an image resource
    private comm(String description, int imageResourceId,String salary,String mand) {

        this.description = description;
        this.imageResourceId = imageResourceId;
        this.salary=salary;
        this.mand=mand;

    }
    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getSalary() {
        return salary;
    }



    public String getMand() {
        return mand;
    }


}


