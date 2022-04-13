package org.example.ch5.advice.InterAdvices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecoratorFirst implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("First");

        Object reValue = invocation.proceed();

        System.out.print("First");

        return reValue;
    }
}
