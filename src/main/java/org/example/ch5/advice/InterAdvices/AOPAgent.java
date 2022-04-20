package org.example.ch5.advice.InterAdvices;

import org.example.ch5.advice.InterAdvices.AgentDecoratorHi;
import org.example.ch5.advice.InterAdvices.AgentDecoratorFirst;
import org.example.ch5.advice.InterAdvices.DecoratorDecorator;
import org.example.ch5.advice.agents.Agent;
import org.example.ch5.advice.InterAdvices.AgentDecorator;
import org.springframework.aop.framework.ProxyFactory;


public class AOPAgent {

    public static void main(String... args){

        Agent agent = new Agent();
        AgentDecoratorFirst ad1 = new AgentDecoratorFirst();
        AgentDecorator ad2 = new AgentDecorator();
        AgentDecoratorHi ad3 = new AgentDecoratorHi(); // hi{}hi
        DecoratorDecorator dd = new DecoratorDecorator(); //декоратор -{}-

        ProxyFactory pfDecorator = new ProxyFactory();
        pfDecorator.setTarget(ad3);
        pfDecorator.addAdvice(dd);
        ad3 = (AgentDecoratorHi) pfDecorator.getProxy();

        ProxyFactory pfDecorator1 = new ProxyFactory();
        pfDecorator1.setTarget(agent);
        pfDecorator1.addAdvice(dd);
        agent = (Agent) pfDecorator1.getProxy();

        ProxyFactory pf = new ProxyFactory();
        //pf.addAdvice(ad1);
        //pf.addAdvice(ad2);
        pf.addAdvice(ad3);
        pf.setTarget(agent);

        Agent proxy = (Agent) pf.getProxy();

        System.out.println("----------------------------------------");
        agent.speak();
        System.out.println("");
        proxy.speak();
        System.out.println("");
        System.out.println("----------------------------------------");
    }
}
