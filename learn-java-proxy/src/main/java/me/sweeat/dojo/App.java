package me.sweeat.dojo;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args){
        JdkTarget target=new JdkTargetImpl();
        Invocation handler=new Invocation(target);
        JdkTarget proxy=(JdkTarget)Proxy.newProxyInstance(
                        target.getClass().getClassLoader(), target.getClass().getInterfaces(),handler);
        proxy.doSomething();
    }
}
