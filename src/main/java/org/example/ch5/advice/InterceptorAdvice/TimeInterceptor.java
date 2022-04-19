package org.example.ch5.advice.InterceptorAdvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class TimeInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());

        Object reVal = invocation.proceed();

        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());
        return reVal;
    }

    private void dumpInfo(MethodInvocation invocation, long ms){

        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: " + m.getName());
        System.out.println("On obj type: " + target.getClass().getName());
        System.out.println("With Args:");
        for(int x = 0; x < args.length; x++){
            System.out.println("> " + args[x]);
        }
        System.out.println("Took: " + ms + "ms");
    }
}
