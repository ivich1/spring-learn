package org.example.ch5.cut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SingerAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print(">>invoking " + invocation.getMethod().getName() + " ");
        Object reVal = invocation.proceed();
        System.out.print(">>done");
        return reVal;
    }
}
