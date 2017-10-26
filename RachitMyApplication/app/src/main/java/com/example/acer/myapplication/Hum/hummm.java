package com.example.acer.myapplication.Hum;

/**
 * Created by acer on 7/15/2016.
 */

import com.example.acer.myapplication.R;


import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class hummm {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final hummm[] drinks = { new hummm("Accessory designers design a range of products that compliment the fashion image such as costume and precious jewelry, leather accessories, footwear, gift products, watches, crafts and lifestyle items, hair accessories etc.",R.drawable.access,"2-10 lakhs","Science, Commerce, Humanities/Arts"),
            new hummm("Animators are artists who draw cartoons and pictures which are used in multimedia productions to entertain, educate or persuade people. Animators use computers to create images, give them colour and use special effects to make a film.",R.drawable.act,"1.15 Lakh to 6.14 Lakhs per annum","arts"),
            new hummm("Beauty business includes specialized areas of work such as hair and skin treatments, make up of TV/Film performers, hair cutting and styling, cosmetology etc.",R.drawable.beau,"61 Thousand to 12.22 Lakhs per annum","Arts"),
            new hummm("Cartoonists use their skill in drawing and sketching to create comic, critical or dramatic pictures to highlight or interpret published information. ",R.drawable.cart,"4-10 lakhs","Arts")
    };






    //Each Drink has a name, description, and an image resource
    private hummm(String description, int imageResourceId,String salary,String mand) {

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



