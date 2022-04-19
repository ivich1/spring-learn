package org.example.ch5.cut.staticCut;

public class NotSinger implements Singer{
    @Override
    public void sing() {
        System.out.print("nonononono");
    }

    @Override
    public void tell() {
        System.out.print("hohohoho");
    }
}
