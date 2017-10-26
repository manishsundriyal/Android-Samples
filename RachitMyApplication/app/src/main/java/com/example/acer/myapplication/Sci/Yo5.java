package com.example.acer.myapplication.Sci;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo5 {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final Yo5[] drinks = {new Yo5("Nursing forms the largest group of professionals who work in the health sector. Their job involves giving bedside care to convalescing patients, attending to newborns, to assisting physicians during examination and operation of patients.",R.drawable.nurse,"72 Thousand to 6 Lakhs per annum","Biology"),
    new Yo5("Journalism is the business of giving news. Journalists work for newspapers, magazines, regional dailies, the electronic medium, websites and for government & public sector publications.",R.drawable.journal,"1.18 Lakh to 9.38 Lakhs per annum","Science, Commerce"),
            new Yo5("Modeling is today an important part of most marketing campaigns. The main areas of modeling are for fashion shows and for fashion photographs or for the electronic medium. Modeling is an art which is a combination of beauty and expression. ",R.drawable.model,"10-20 Lakhs","Science, Commerce"),
            new Yo5("Police officers are responsible for public safety, maintaining law and order, prevention of crime and enforcement of law.",R.drawable.po,"2-7 lakhs","science,commerce"),
            new Yo5("Teaching is one of the largest professions. Teachers specialize to teach at different levels such as the pre-primary, primary, secondary, senior secondary and university levels. ",R.drawable.teacher,"1.22 Lakh to 4.88 Lakhs per annum","Science,Maths")};



    //Each Drink has a name, description, and an image resource
    private Yo5(String description, int imageResourceId,String salary,String mand) {

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



