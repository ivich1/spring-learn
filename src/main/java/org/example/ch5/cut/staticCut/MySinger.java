package org.example.ch5.cut.staticCut;

public class MySinger implements Singer{
    @Override
    public void sing() {
        System.out.print("mymymymymymy");
    }

    @Override
    public void tell() {
        System.out.print("hmhmhmhmhm");
    }


}
