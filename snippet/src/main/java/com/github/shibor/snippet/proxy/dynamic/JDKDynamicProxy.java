package com.github.shibor.snippet.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

    public static void main(String[] args) {
        System.out.println("案例一：");
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invocationHandler invoke:");
                // return method.invoke(proxy,args);
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);
        hello.method1("Bob");
        hello.method2();
        System.out.println("#####################");



        System.out.println("案例二：");
        Hello helloImpl = (Hello) Proxy.newProxyInstance(
                HelloImp.class.getClassLoader(),
                new Class[]{Hello.class},
                handler);
        helloImpl.method1("Bob");
        helloImpl.method2();
        System.out.println("#####################");


        System.out.println("案例三：");
        Hello helloProxy = new JDKDynamicProxy(new HelloImp()).getProxy();
        helloProxy.method1("proxy");
        helloProxy.method2();
        System.out.println("#####################");
    }

    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public <T> T getProxy() {
       return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}


