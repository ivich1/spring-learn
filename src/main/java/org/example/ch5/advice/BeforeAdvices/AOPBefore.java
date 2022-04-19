package org.example.ch5.advice.BeforeAdvices;

import org.example.ch5.advice.BeforeAdvices.BeforeAdvice;
import org.example.ch5.advice.agents.Agent;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class AOPBefore {

    public static void main(String ... args) {
        Agent johnMayer = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new BeforeAdvice());
        pf.setTarget(johnMayer);
        Agent proxy = (Agent) pf.getProxy();
        proxy.speak();
    }
}
