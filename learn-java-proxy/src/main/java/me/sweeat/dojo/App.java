package me.sweeat.dojo;

import me.sweeat.dojo.cglib.CgTarget;
import me.sweeat.dojo.cglib.CglibProxy;
import me.sweeat.dojo.jdk.Invocation;
import me.sweeat.dojo.jdk.Target;
import me.sweeat.dojo.jdk.TargetImpl;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args){
        Target target=new TargetImpl();
        Invocation handler=new Invocation(target);
        Target proxy=(Target)Proxy.newProxyInstance(
                        target.getClass().getClassLoader(), target.getClass().getInterfaces(),handler);
        proxy.doSomething();

        CglibProxy cgProxy=new CglibProxy();
        CgTarget cgTarget=(CgTarget)cgProxy.getProxy(CgTarget.class);
        cgTarget.doSomething();
    }
}
