package org.example.ch5;

import org.example.ch5.advice.InterAdvices.AgentDecoratorHi;
import org.example.ch5.advice.InterAdvices.AgentDecoratorFirst;
import org.example.ch5.advice.InterAdvices.DecoratorDecorator;
import org.example.ch5.advice.agents.Agent;
import org.example.ch5.advice.InterAdvices.AgentDecorator;
import org.springframework.aop.framework.ProxyFactory;


public class AOPAgent {

    public static void main(String... args){
        Agent agent = new Agent();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecoratorFirst());
        pf.addAdvice(new AgentDecorator());
        pf.addAdvice(new AgentDecoratorHi());
        pf.setTarget(agent);

        ProxyFactory dd = new ProxyFactory();
        dd.addAdvice(new DecoratorDecorator());
        dd.setTarget(pf);

        ProxyFactory pfdd = (ProxyFactory) dd.getProxy();




        Agent proxy = (Agent) pfdd.getProxy();

        System.out.println("----------------------------------------");
        agent.speak();
        System.out.println("");
        proxy.speak();
        System.out.println("");
        System.out.println("----------------------------------------");



    }
}
