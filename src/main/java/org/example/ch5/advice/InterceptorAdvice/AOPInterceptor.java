package org.example.ch5.advice.InterceptorAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class AOPInterceptor {

    public static void main(String... args){
        WorkBean work = getWorkerBean();
        work.doWork(1000);
    }

    private static WorkBean getWorkerBean(){
        WorkBean w = new WorkBean();
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(w);
        pf.addAdvice(new TimeInterceptor());

        return (WorkBean) pf.getProxy();
    }
}
