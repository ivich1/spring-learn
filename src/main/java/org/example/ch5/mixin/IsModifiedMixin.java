package org.example.ch5.mixin;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified
{
    private Map<Method, Method> methodCache = new HashMap<>();
    private boolean isModified;

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    public Object invoke(MethodInvocation invocation){
        if(!isModified){
            if((invocation.getMethod()).getName().startsWith("set")
            && (invocation.getArguments().length == 1)){
                Method getter = getGetter(invocation.getMethod());

                if(getter != null){
                    Object newVal = invocation.getArguments()[0];
                    Object oldVal = getter.invoke(invocation.getThis(), null);

                    if(newVal == null && oldVal == null){
                        isModified = false;
                    }
                    if(newVal != null && oldVal == null){
                        isModified = true;
                    }
                    if(newVal == null && oldVal != null){
                        isModified = true;
                    }
                    else{
                        isModified = !newVal.equals(oldVal);
                    }
                }
            }
        }
        return super.invoke(invocation);
    }

    private Method getGetter(Method setter){
        Method getter = methodCache.get(setter);
        if(getter != null){
            return getter;
        }

        String getterName = setter.getName().replace("set","get");
        try{
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            synchronized (methodCache){
                methodCache.put(setter,getter);
            }
            return getter;
        } catch (NoSuchMethodException e){
            return null;
        }
    }
}
