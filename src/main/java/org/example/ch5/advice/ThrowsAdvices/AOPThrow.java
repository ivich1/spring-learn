package org.example.ch5.advice.ThrowsAdvices;

import org.springframework.aop.framework.ProxyFactory;

public class AOPThrow {

    public static void main(String... args){
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ThrowAdvice());
        pf.setTarget(errorBean);
        ErrorBean errorBean1 = (ErrorBean) pf.getProxy();

        try {
            errorBean1.errorProneMethod();
        }catch (Exception e){

        }
        try {
            errorBean1.otherErrorMethod();
        }catch (Exception e){

        }

    }
}
