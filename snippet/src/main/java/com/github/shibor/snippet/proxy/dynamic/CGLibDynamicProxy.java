package com.github.shibor.snippet.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy implements MethodInterceptor {
    public static void main(String[] args) {
        //目标对象
        Hello target = new HelloImp();
        System.out.println(target.getClass());
        //代理对象
        Hello proxy = (Hello) new CGLibDynamicProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.method1("cgl");
        proxy.method2();
    }

    private Object target;

    public CGLibDynamicProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("after");
        return returnValue;
    }

    public Object getProxyInstance() {
        return Enhancer.create(target.getClass(), this);
    }


}
