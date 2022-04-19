package org.example.ch5.advice.InterceptorAdvice;

public class WorkBean {
    public void doWork(int times){
        for (int i = 0; i < times; i++){
            //work();
            System.out.println("work");
        }
    }
    private void work(){
        System.out.println("work");
    }
}
