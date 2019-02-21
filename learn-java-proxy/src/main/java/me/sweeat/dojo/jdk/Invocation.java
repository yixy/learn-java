package me.sweeat.dojo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Invocation implements InvocationHandler {
    private Object target;

    public Invocation(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target.getClass().getName()+"."+method.getName()+" start.");
        Object obj=method.invoke(target,args);
        System.out.println(target.getClass().getName()+"."+method.getName()+" end.");
        return obj;
    }
}
