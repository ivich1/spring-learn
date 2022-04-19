package org.example.ch5.advice.ThrowsAdvices;

public class ErrorBean {

    public void errorProneMethod() throws Exception{
        throw new Exception("this is exception");
    }

    public void otherErrorMethod() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalAccessError");
    }
}
