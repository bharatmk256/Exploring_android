package com.bharatmk257.interfacejava;

//public abstract class Boxer implements Fighting{ //inheritance but we have to put abstract before class so it becomes abstract class  or see below what i had done

public class Boxer implements Fighting{

    @Override
    public String throwJab() {
        return "Throw Faster Jab";
    }

    @Override
    public String throwCross() {
        return "Throw Faster Cross";
    }

    @Override
    public String throwHook() {
        return "Throw Faster Hook";
    }

    @Override
    public String throwUppercut() {
        return "Throw Faster Uppercut";
    }
}
