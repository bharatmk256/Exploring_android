package com.bharatmk257.interfacejava;

public class KickBoxer implements Fighting {

    @Override
    public String throwJab() {
        return "Throw Harder Jab";
    }

    @Override
    public String throwCross() {
        return "Throw Harder cross";
    }

    @Override
    public String throwHook() {
        return "Throw Harder Hook";
    }

    @Override
    public String throwUppercut() {
        return "Throw Harder Uppercut";
    }
}
