package com.github.shibor.snippet.proxy.dynamic;

class HelloImp implements Hello {

    @Override
    public void method1(String msg) {
        System.out.println("HelloImp method1");
        System.out.println(msg);
    }

    @Override
    public void method2() {
        System.out.println("HelloImp method2");
    }
}
