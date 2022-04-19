package org.example.ch5.cut.dynamicCut;

import org.example.ch5.cut.staticCut.SingerAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutDemo {

    public  static void main(String... args){
        SampleBean sampleBean = new SampleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new DynamicCut(), new SingerAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(sampleBean);

        SampleBean proxy = (SampleBean) pf.getProxy();

        proxy.foo(1);
        proxy.foo(100);

        proxy.bar();
        proxy.bar();
    }
}
