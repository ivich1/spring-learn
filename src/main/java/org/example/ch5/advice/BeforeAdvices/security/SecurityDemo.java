package org.example.ch5.advice.BeforeAdvices.security;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {

    public static void main(String... args){
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean();

        //ок
        mgr.login("John", "pwd");
        bean.printSecureMessage();
        mgr.logout();
        System.out.println();

        //не ок
        try{
            mgr.login("noJohn", "pwd");
            bean.printSecureMessage();
        } catch (SecurityException e){
            System.out.println(e.getMessage());
        }finally {
            mgr.logout();
        }
        System.out.println();

        //не ок
        try {
            bean.printSecureMessage();
        }catch (SecurityException e){
            e.getMessage();
        }
        System.out.println();
    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean s = (SecureBean) factory.getProxy();
        return s;
    }
}
