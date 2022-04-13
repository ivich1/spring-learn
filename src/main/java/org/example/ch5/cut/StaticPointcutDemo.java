package org.example.ch5.cut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public  static void main(String... args){

        MySinger mySinger = new MySinger();
        NotSinger notSinger = new NotSinger();

        Singer proxy1;
        Singer proxy2;

        Pointcut pc = new SingerStaticPointcut();
        Advice advice = new SingerAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(mySinger);
        proxy1 = (Singer)pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(notSinger);
        proxy2 = (Singer)pf.getProxy();

        proxy1.sing();
        System.out.println();
        proxy2.sing();
    }
}
