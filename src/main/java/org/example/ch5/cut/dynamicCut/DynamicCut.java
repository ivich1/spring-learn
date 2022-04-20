package org.example.ch5.cut.dynamicCut;

import org.example.ch5.cut.staticCut.MySinger;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class DynamicCut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Dynamic check for " + method.getName());
        int x = (Integer) args[0];
        return (x < 100);
    }

    private String targetMethodName = "foo";
    @Override
    public boolean matches(Method method, Class<?> cls) {
        System.out.println("Static check for " + method.getName());
        return (targetMethodName.equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return cls -> (cls == SampleBean.class);
    }
}
