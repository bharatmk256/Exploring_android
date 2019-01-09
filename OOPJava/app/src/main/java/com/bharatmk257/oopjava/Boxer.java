package com.bharatmk257.oopjava;

//at the end i have commented many thing but this class inheriting from fighter class so some comment should be editable so do it yourself :)


public class Boxer extends Fighter {


//    private int numberOfGloves = 2;  // we use this as private because of other class can't manipulate it's properties  // access modifier
    // other method is getters and setter we will use in next some projects


    private static int stamina = 59;
    // this value is share so static means when i create 2 new object from this class and set one value to 20 it will automatically set second's value 20

//    public int getNumberOfGloves() { //getter method
//        return getNumberOfGloves(); // returns value of number of gloves so we can use this
//    }


//    public void setNumberOfGloves(int numberOfGloves) { // () will be use while setting from other class we will get valuse and set it to number of gloves
//
//        if (numberOfGloves == 0) {
//            return; // stop code here if number of gloves == 0
//        }

//        setNumberOfGloves(numberOfGloves);
//
//        //this.numberOfGloves = numberOfGloves;
//        // 1. this means instance variable that declared in class so we ar refering instance variable using this.method
//        // 2. number of gloves is another variable that created in setter method
//    }
//
//    public Boxer(){  // this is created constructor also the name of constructor must be name of class
//
//        punchSpeed = 300;
//        punchPower = 500;
//        numberOfGloves = 2;
//
//        //if we use this class it automatically initialize value to new object
//
//    }


    public Boxer(int punchSpeed, int punchPower, int numberOfGloves) {

        super(punchSpeed, punchPower, numberOfGloves);
        // means we have to call super class for this data if we are setting constructor   (super == fighter class = true) for this class
        // we have to pass parameter if super class have if not leave it blank

        if (punchSpeed <= 0 || punchPower <= 0 || numberOfGloves <= 0) {
            return;
        }

//       this.punchSpeed = punchSpeed;
//       this.punchPower = punchPower;
//       this.numberOfGloves = numberOfGloves;

        setPunchSpeed(punchSpeed);
        setPunchPower(punchPower);
        setNumberOfGloves(numberOfGloves);


    }

    // okay so this type of constructor is used when we initialize new object on other class we have to give value every time


//    public int getPunchSpeed() {
////        return punchSpeed;
//        return getPunchSpeed();
//    }
//
//    public void setPunchSpeed(int punchSpeed) {
////        this.punchSpeed = punchSpeed;
//        setPunchSpeed(punchSpeed);
//    }
//
//    public int getPunchPower() {
////        return punchPower;
//        return getPunchPower();
//    }
//
//    public void setPunchPower(int punchPower) {
////        this.punchPower = punchPower;
//        setPunchPower(punchPower);
//    }

    public static int getStamina() {
        return stamina;
    }

    public static void setStamina(int stamina) {
        Boxer.stamina = stamina;
    }

    public String throwJab() {
        return "Jab";
    }
    public String throwKick(){
        return "Kick";
    }

    @Override
    // already methode is defined in other class and we still want to change some implementation in it so we use override methode so it will re write methode for us
    public void setPunchSpeed(int punchSpeed) {
        super.setPunchSpeed(punchSpeed);
    }
}
