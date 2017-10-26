package com.example.acer.myapplication.Sci;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo4 {


    private String description;
    private int imageResourceId;
    private String salary;
    private String mand;


    //drinks is an array of Drinks
    public static final Yo4[] drinks = { new Yo4("Architects design and plan buildings and structure which are appropriate in terms of materials and design and also meet the client's specifications.",R.drawable.architect,"1.25 Lakh to 17.52 Lakhs per annum","Mathematics")
            ,new Yo4("A cinematographer is also known as the director of photography. He is responsible for filming a movie or TV program. He uses many different technical devices for ensuring perfection in the shots, colour, framing, exposure and lighting.",R.drawable.cinema,"4-10 Lakhs","Maths, Physics")
            ,new Yo4("An actor portrays a character and communicates with the audience on behalf of the playwright, guided by a director. Actors work mainly indoors in theatres & studios, and also do on location shoots for films & television.",R.drawable.actor,"not defined","Science")
            ,new Yo4("Animators are artists who draw cartoons and pictures which are used in multimedia productions to entertain, educate or persuade people.",R.drawable.animation,"1.15 Lakh to 6.14 Lakhs per annum","Science, Commerce")
            ,new Yo4("Cartoonists use their skill in drawing and sketching to create comic, critical or dramatic pictures to highlight or interpret published information. They may create illustrations, portraits, comic strips, animations, story board etc",R.drawable.carttoonist,"5-10lakhs","Science, Commerce")
            ,new Yo4("Choreographers create original dance acts and make new interpretations of traditional dance forms. They blend Indian and western forms of dance. They teach and direct performers in movies, theatre and reality shows.",R.drawable.choreo,"20-30lakhs","Humanities/Arts")
            ,new Yo4("Fashion Designers design garments which are functional as well as attractive and in keeping with trends, market predictions and the climate. ",R.drawable.designer,"1.69 Lakh to 7.67 Lakhs per annum","Science,Arts")
            ,new Yo4("The director is in complete charge of the studio or location floor and controls the film artistically, having the final say on all creative matters. Film directors generally have assistant directors to help them on the sets during filming",R.drawable.director,"not defined","Science, Commerce")
            ,new Yo4("Web designers creatively design the visual elements that make up a web page - the layout, colour scheme, and general design of a website.",R.drawable.gd,"5-19 lakhs","Science, Commerce, Humanities/Arts")
            ,new Yo4("Mobile designers are known by many names such as app designers, iOS designers, Android designers, etc. ",R.drawable.appd,"5-10Lakhs","Science")};




    //Each Drink has a name, description, and an image resource
    private Yo4(String description, int imageResourceId,String salary,String mand) {

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



