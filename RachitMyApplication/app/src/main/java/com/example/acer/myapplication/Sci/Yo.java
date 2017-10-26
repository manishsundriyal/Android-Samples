package com.example.acer.myapplication.Sci;

import com.example.acer.myapplication.R;

/**
 * Created by acer on 7/11/2016.
 */
public class Yo {






        private String name;
        private String description;
        private int imageResourceId;
        private String salary;
        private String mand;


        //drinks is an array of Drinks
        public static final Yo[] drinks = {

                new Yo("Aeronautical Engineer","Engineers work as part of a team that maintains the aircrafts and ensures high level of technical precision. Main thrust of the engineering profession lies in design, development, maintenance & teaching of aeronautics.", R.drawable.aeronautical,"2.34 Lakhs to 49.42 Lakhs per annum","Maths, Physics"),
                new Yo("Aerospace Engineer","Manufacturing of aircrafts for commercial or military use is a highly technical field. Tremendous amount of Research and Development function precedes production of an aircraft. ",R.drawable.aerospace,"2.76 Lakhs to 33.67 Lakhs per annum"," Physics"),
                new Yo("Agricultural Engineer","Agricultural engineers learn and apply the principles of engineering to work in the agricultural equipment industries, agricultural product processing industries and food industries.",R.drawable.agricultural,"2-5 Lakhs per annum","Chemistry, Mathematics, Physics"),
                new Yo("Air Traffic Control Officer","Air Traffic Controllers monitor and direct the movement of air traffic in and around airports and enroute on specified paths directing the planes to stay safe distances from each other.",R.drawable.airtraffic,"1.18 Lakh to 10.94 Lakhs per annum"," Mathematics, Physics"),
                new Yo("Aircraft Maintenance Engineer","Aircrafts have to be maintained and serviced regularly for efficiency, safety and air-worthiness.",R.drawable.aircraftm,"2 lakhs to 10 lakhs per annum","Mathematics, Physics"),
                new Yo("Architect","Architects design and plan buildings and structure which are appropriate in terms of materials and design and also meet the client's specifications.",R.drawable.architect,"1.25 Lakh to 17.52 Lakhs per annum","Mathematics"),
                new Yo("Audio Recording Engineers","Sound Recording Engineers are technical experts who use recording equipment to record music, TV, film and radio productions.",R.drawable.audioengineer,"2-7 Lakhs","Medium"),
                new Yo("Biomedical Engineer","Biomedical engineers integrate the knowledge of biology and medicine to analyze and devise solutions for improving healthcare in terms of quality and effecacy.",R.drawable.biomedical,"1.12 Lakh to 6.49 Lakhs per annum","Chemistry, Mathematics, Physics"),
                new Yo("Broadcast Engineer","Broadcast engineers are involved in the transmission of audio and video programs for the public using high end electronic equipment",R.drawable.maxresdefault,"1.41 Lakh to 8.45 Lakhs per annum","Mathematics, Physics"),
                new Yo("Chemical Engineer","Chemical Engineers work out economically efficient, safe and environment friendly methods for production of chemicals on a large scale. ",R.drawable.chemical,"1.76 Lakh to 12.3 Lakhs per annum","Biology, Chemistry, Mathematics"),
                new Yo("Dentist","Dentistry is concerned with prevention and treatment of all health problems affecting the mouth, teeth, gums and other hard and soft tissues of the oral cavity. ",R.drawable.den,"97 Thousand to 11.56 Lakhs per annum","Biology"),
                new Yo("Electrical Engineer","Electrical Engineers are involved in the manufacturing of electrical equipment such as power generation equipment, electric motors, radar and navigation systems, communication systems, electrical systems of automobiles, ships and aircrafts.",R.drawable.elec,"1.43 Lakh to 8.02 Lakhs per annum","Chemistry, Mathematics, Physics"),
                new Yo("Electronic Engineer","Electronic engineers design and manufacture electronic devices such as computers , telephones etc. and electronic components used in a range of products.",R.drawable.etron,"1.41 Lakh to 8.63 Lakhs per annum"," Mathematics, Physics"),
                new Yo("Engineer","Engineers specialize in different branches of engineering e.g. Mechanical, Electrical, Electronics, Chemical, Biomedical etc. They work in designing, planning large structures, maintenance, production, or testing of machines and equipment used in different sectors. ",R.drawable.engi,"2-10Lakhs","Mathematics, Physics"),
                new Yo("Engineering Technician","Engineering Technicians assist engineers & scientists in assembly, and repair as well as experiment oriented tasks. Technicians specialize in an engineering discipline or undergo special training for specific industries. ",R.drawable.tech,"1.18 Lakh to 8.93 Lakhs per annum","Mathematics, Physics"),
                new Yo("Instrumentation Engineer","Instrumentation Engineering is a multidisciplinary field and a specialist branch of electrical and electronics engineering. ",R.drawable.ins," 1.75 Lakh to 9.41 Lakhs per annum","Chemistry, Mathematics, Physics"),
                new Yo("Marine Engineer","Marine engineers design, construct, maintain and repair all types of sea-going vessels and structures used at sea.",R.drawable.marine,"3.58 Lakhs to 37.03 Lakhs per annum"," Chemistry, Mathematics, Physics"),
                new Yo("Merchant Navy Officer","Merchant navy is a commercial fleet which includes cargo ships, container ships, barge carrying ships, tankers, bulk carriers, refrigerator ships, passenger ships as well as roll off/roll on ships.",R.drawable.mer,"5-10Lakhs","Physics"),
                new Yo("Naval Officer","The Navy protects and safeguards the country's exclusive economic zone, the ocean resources and the coasts from any invasion. Navy consists of the combat fleet, support ships, personnel, training establishments and the land bases.",R.drawable.nava,"5-12 Lakhs","Mathematics, Physics"),
                new Yo("Petroleum Engineer","Petroleum Engineers work in drilling oil wells, safe and economical recovery of oil and natural gas, development and processing of petroleum, and management of the production process.",R.drawable.pet,"2.82 Lakhs to 37.73 Lakhs per annum","Chemistry, Mathematics, Physics"),
                new Yo("Pilot","The pilot is a key person in airline operations concerned mainly with flying of the aircraft's on scheduled routes. ",R.drawable.plt,"1.12 Lakh to 36.85 Lakhs per annum","Maths, Physics"),
                new Yo("Robotics Engineer","Robotic Engineers design and maintain robots. They are constantly engaged in research to develop new designs and expand their potential.",R.drawable.robo,"4-10 lakhs","Chemistry, Mathematics, Physics"),

        };

        //Each Drink has a name, description, and an image resource
        private Yo(String name, String description, int imageResourceId,String salary,String mand) {
            this.name = name;
            this.description = description;
            this.imageResourceId = imageResourceId;
            this.salary=salary;
            this.mand=mand;

        }
        public String getDescription() {
            return description;
        }
        public String getName() {
            return name;
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

    public String toString() {
            return this.name;
        }
    }

