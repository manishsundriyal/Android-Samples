package com.example.acer.myapplication.Sci;
import com.example.acer.myapplication.R;

;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo6 {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final Yo6[] drinks = {new Yo6("Botanists are scientists who study plant life, trees, foliage etc. They study the cell formation and structure, propagation and environmental conditions best suited for growth and sustenance.",R.drawable.bot,"2-8lakhs","Biology"),
            new Yo6("Oceanographers study the seas, its coastline, estuaries, coastal waters, shelves and the ocean bed. The study is used for preparation of maps, charts and graphs as well as research and development activities in all branches of ocean science for use in subsequent technology development.",R.drawable.ocean,"2-5 lakhs","Maths, Physics"),
            new Yo6("Copy writing involves providing words which are read or heard in advertisements. This may include slogans or jingles or detailed text for catalogues, brochures, leaflets and journals. Copy writing also takes the form of scripts for television and film commercial advertisement.",R.drawable.copy,"1.16 Lakh to 4.53 Lakhs per annum"," Science"),
            };


    //Each Drink has a name, description, and an image resource
    private Yo6(String description, int imageResourceId,String salary,String mand) {

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



