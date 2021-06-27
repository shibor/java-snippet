package com.github.shibor.snippet.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * <p>
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 *
 * @author shibor
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        Action proxy = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Action.class},
                new ProxyHandler(realObject));
        proxy.doSomething();
    }
}


interface Action {

    void doSomething();
}

class RealObject implements Action {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }
}

class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始事务");
        //执行目标对象方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务");
        return returnValue;
    }
}