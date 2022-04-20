package org.example.ch5.cut.anotationCut;

import org.example.ch5.cut.staticCut.Singer;

public class SleepSinger implements Singer {

    @AdviceRequired
    public void rest(){
        System.out.println("zzz");
    }

    @Override
    public void sing() {
        System.out.println("zzz-zzz");
    }

    @Override
    public void tell() {

    }
}
