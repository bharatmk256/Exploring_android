package com.bharatmk257.oopjava;

public class KickBoxer extends Boxer {

    private int kickSpeed = 50;
    private int kickPower = 70;


    public int getKickSpeed(){
        return kickSpeed;
    }
    public int getKickPower(){
        return kickPower;
    }
//    public int getPunchSpeed(){
////        return punchSpeed;
//        return getPunchSpeed();
//    }
//    public int getPunchPower(){
////        return punchPower;
//        return getPunchPower();
//    }


    public void setKickSpeed(int kickSpeed){
        this.kickSpeed = kickSpeed;
    }
    public void setKickPower(int kickPower){
        this.kickPower = kickPower;
    }


//    public void setPunchSpeed(int punchSpeed){
////        this.punchSpeed = punchSpeed;
//        setPunchSpeed(punchSpeed);
//    }
//    public void setPunchPower(int punchPower){
////        this.punchPower = punchPower;
//        setKickPower(punchPower);
//    }


    public KickBoxer(int numberOfGloves,int kickSpeed, int kickPower, int punchSpeed, int punchPower) {

        super(numberOfGloves,punchSpeed,punchPower);

        this.kickSpeed = kickSpeed;
        this.kickPower = kickPower;
//        this.punchSpeed = punchSpeed;
        setPunchSpeed(punchSpeed);
//        this.punchPower = punchPower;
        setPunchPower(punchPower);
    }
}
