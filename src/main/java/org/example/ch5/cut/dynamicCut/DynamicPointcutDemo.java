package org.example.ch5.cut.dynamicCut;

import org.example.ch5.cut.staticCut.SingerAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class DynamicPointcutDemo {

    public  static void main(String... args){
        SampleBean sampleBean = new SampleBean();

        //фильтр по имеам методов
        //NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        //pc.addMethodName("bar");
        JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
        pc.setPattern(".*bar.*");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SingerAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(sampleBean);

        SampleBean proxy = (SampleBean) pf.getProxy();

        proxy.foo(1);
        System.out.println();
        proxy.foo(100);
        System.out.println();
        /*
        Закончил на 350 странице
         */

        proxy.bar();
        System.out.println();
        proxy.bar();
        System.out.println();
        proxy.bar(3);
    }
}
