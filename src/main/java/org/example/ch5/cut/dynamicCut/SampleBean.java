package org.example.ch5.cut.dynamicCut;

public class SampleBean {
    public void foo(int x){
        System.out.print("Invoked foo(): with " + x);
    }

    public void bar(){
        System.out.print("Invoked bar():");
    }
    public void bar(int x){
        for(int i = 0; i < x; i++ ){
            System.out.println("Invoking bar(" + x + "):" + i);
        }
        System.out.println("Invoked bar(" + x + "):");
    }
}
