package org.example.ch5.cut.staticCut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SingerStaticPointcut extends StaticMethodMatcherPointcut {

    private String targetMethodName = "sing";
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return (targetMethodName.equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return cls -> (cls == MySinger.class);
    }
}
