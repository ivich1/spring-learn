package org.example.ch5.cut.anotationCut;

import org.example.ch5.cut.staticCut.SingerAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AOPTestAnotation {
    public static void main(String... args){
        SleepSinger sleepSinger = new SleepSinger();

        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        Advisor a = new DefaultPointcutAdvisor(pc,new SingerAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(a);
        //pf.addAdvice(new SingerAdvice());
        pf.setTarget(sleepSinger);

        sleepSinger = (SleepSinger) pf.getProxy();

        sleepSinger.sing();
        sleepSinger.rest();
    }
}
