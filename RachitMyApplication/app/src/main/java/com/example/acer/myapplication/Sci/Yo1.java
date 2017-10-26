package com.example.acer.myapplication.Sci;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo1 {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final Yo1[] drinks = { new Yo1("Mobile applications are designed for infotainment and entertainment.",R.drawable.mob,"4.21 Lakhs to 20.36 Lakhs per annum","Mathematics, Physics"),
            new Yo1("Project managers are at the helm of the planning, management and financial control of a project in an organization.",R.drawable.proj,"3.47 Lakhs to 16.25 Lakhs per annum","Mathematics")
            , new Yo1("Accountants work for individual and institutional clients. They maintain their accounts and keep a record of all financial transactions.",R.drawable.acc,"1.03 Lakh to 4.68 Lakhs per annum","Mathematics"),
            new Yo1("Chartered Accountants deal with the management of money and provide financial advice. ",R.drawable.charq," 2.93 Lakhs to 15.18 Lakhs per annum","Science, Commerce"),
            new Yo1("Financial managers prepare financial reports, advise on investments and are involved in financial management strategies and planning for business viability.",R.drawable.fin,"4.06 Lakhs to 18.87 Lakhs per annum","Science, Commerce"),
            new Yo1("Bakers produce baked goods such as cakes, pastries, breads, pies, cookies, biscuits and crackers etc. in commercial and retail bakeries.",R.drawable.baker,"62 Thousand to 17.75 Lakhs per annum","Science, Commerce, Humanities/Arts"),
            new Yo1("Banking professionals handle client's money - In simple terms, they help individuals & corporates with their investments, loans and all other money related issues.",R.drawable.banker,"1.35 Lakh to 4.7 Lakhs per annum"," Maths"),
            new Yo1("Management consultants help clients improve business performance and growth. Consultants provide them with information and expert advice to get a real and lasting solution to complex issues. ",R.drawable.consult,"4-10lakhs","Science"),
            new Yo1("Economists analyze issues related to growth and development, welfare and policy formulation, and assess their long and short term significance for the country.",R.drawable.economy,"1.88 Lakh to 14.81 Lakhs per annum","Economics, Maths"),
            new Yo1("Entrepreneurs are independent-minded, innovative business people who have skill sets, which make them self-starters.",R.drawable.entre,"10-50 lakhs","Science")

    };


    //Each Drink has a name, description, and an image resource
    private Yo1(String description, int imageResourceId,String salary,String mand) {

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


