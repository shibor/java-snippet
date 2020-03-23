package com.github.shibor.snippet.designpattern.proxy.staticproxy;

/**
 * <h>
 * 静态代理
 * </h>
 * <p>
 * 代理类和目标类实现同一接口
 * 方法必须一个一个去拦截
 * </p>
 *
 * @author shibor
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        ProxyAction proxy = new ProxyAction(new RealObject());
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

class ProxyAction implements Action {
    private Action realObject;

    public ProxyAction(Action realObject) {
        this.realObject = realObject;
    }

    @Override
    public void doSomething() {
        System.out.println("proxy before do");
        realObject.doSomething();
        System.out.println("proxy after do");
    }
}