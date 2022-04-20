package org.example.ch5.advice.InterAdvices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecoratorHi implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("Hi");

        Object reValue = invocation.proceed();

        System.out.print("Hi");

        return reValue;
    }
}
