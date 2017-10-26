package com.example.acer.myapplication.Sci;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo3 {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final Yo3[] drinks = {new Yo3("Astronomy is an observational science which studies heavenly bodies - stars, planets, comets, asteroids as well as man made satellites",R.drawable.astronomer,"12-15lakhs","Mathematics, Physics")
            ,new Yo3("Biology is the study of living things. Biology includes fields such as Agronomy, Animal Husbandry, Biochemistry, Forestry, Horticulture, Fish and Wildlife Conservation and Range Management. ",R.drawable.biology,"5-12 lakhs","Biology")
            ,new Yo3("Cardiologists are physicians who diagnose and treat heart and cardiovascular ailments. They may specialize in noninvasive, invasive and interventional cardiology.",R.drawable.cardio,"10-15lakhs","Chemistry, Mathematics, Physics")
            ,new Yo3("Systems software developers work on operating systems which are crucial to software. This system determines the way the computer will work.",R.drawable.computere,"2.15 Lakhs to 8.04 Lakhs per annum","Maths")
            ,new Yo3("Database Administrators design, install, maintain, update, modify and trouble shoot computer database systems",R.drawable.dba,"1.81 Lakh to 9.47 Lakhs per annum","Chemistry, Mathematics, Physics")
            ,new Yo3("The Medical career centers around the hospital. Physician diagnose a patient, and prescribes medicines and treatment for disease, while surgeons perform operations.",R.drawable.doc,"4-15 Lakhs"," Biology, Chemistry")
            ,new Yo3("Ethical hackers work for all organizations which have an internet presence. Ethical Hackers role is a proactive one as they prevent cyber- crimes and protect cyber space from intrusion. ",R.drawable.hack,"11.94 Lakhs to 99.99 Lakhs per annum"," Chemistry, Mathematics, Physics")
            ,new Yo3("Homoeopathy is based on the chemical principal of ‘similar similibus curentur’ which means let likes be cured by likes. This is an alternative form of treatment which is non invasive and very different from the allopathic form.",R.drawable.homeo,"2-10 lakhs","Biology")
            ,new Yo3("Psychology is both a science and a profession. As a science it is a systematic approach to the understanding of people and their behavior. Psychology can be broadly defined as the study of the mind (normal or abnormal.",R.drawable.physco,"1.19 Lakh to 9.96 Lakhs per annum","Psychology")
            };



    //Each Drink has a name, description, and an image resource
    private Yo3(String description, int imageResourceId,String salary,String mand) {

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


