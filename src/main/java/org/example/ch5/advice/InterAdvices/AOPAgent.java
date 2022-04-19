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
        AgentDecoratorHi ad3 = new AgentDecoratorHi();

        ProxyFactory dd = new ProxyFactory();
        dd.addAdvice(new DecoratorDecorator());
        dd.setTarget(ad1);
        AgentDecoratorFirst adf = (AgentDecoratorFirst)dd.getProxy();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(adf);
        pf.addAdvice(ad2);
        pf.addAdvice(ad3);
        pf.setTarget(agent);



        ProxyFactory pfdd = (ProxyFactory) dd.getProxy();

        Agent proxy = (Agent) pf.getProxy();

        System.out.println("----------------------------------------");
        agent.speak();
        System.out.println("");
        proxy.speak();
        System.out.println("");
        System.out.println("----------------------------------------");



    }
}
