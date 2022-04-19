package org.example.ch5.advice.BeforeAdvices.security;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice(){
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        UserInfo user = securityManager.getLoggedUser();

        if(user == null){
            System.out.print("no user");
            throw new SecurityException("no user? auth");
        }
        else if("John".equals(user.getUserName())){
            System.out.print("ok");
        }
        else{
            System.out.print("not ok");
            throw new SecurityException("incorrect user");
        }

    }
}
