package org.example.ch5.advice.AfterAdvice;

import org.example.ch5.advice.agents.Agent;
import org.springframework.aop.framework.ProxyFactory;

public class AOPAfter {

    Agent agent = new Agent();

    public static void main(String... args){

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AfterAdviceReturn());
        pf.setTarget(new Agent());

        Agent a = (Agent) pf.getProxy();
        a.speak();
    }

}
