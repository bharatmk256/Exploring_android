package com.bharatmk257.oopjava;

public class Fighter {


    private int punchSpeed;
    private int punchPower;
    private int numberOfGloves;

    public int getPunchSpeed() {
        return punchSpeed;
    }

    public void setPunchSpeed(int punchSpeed) {
        this.punchSpeed = punchSpeed;
    }

    public int getPunchPower() {
        return punchPower;
    }

    public void setPunchPower(int punchPower) {
        this.punchPower = punchPower;
    }

    public int getNumberOfGloves() {
        return numberOfGloves;
    }

    public void setNumberOfGloves(int numberOfGloves) {
        this.numberOfGloves = numberOfGloves;
    }

    public Fighter(int punchSpeed, int punchPower, int numberOfGloves) {
        this.punchSpeed = punchSpeed;
        this.punchPower = punchPower;
        this.numberOfGloves = numberOfGloves;
    }
}
