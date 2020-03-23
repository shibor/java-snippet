package com.github.shibor.snippet.designpattern.singleton;

/**
 * <h>
 * 单例模式
 * </h>
 * 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * @author shibor
 */
public class SingletonDemo {

    public static void main(String[] args) {
        // 获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();

        SingletonLazyObject.getInstance();

        SingletonDCL.getInstance();

        SingletonStatic.getInstance();
    }
}

/**
 * 饿汉式
 */
class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }
}

/**
 * 懒汉式
 */
class SingletonLazyObject {

    private static SingletonLazyObject instance;

    private SingletonLazyObject() {
    }

    public static synchronized SingletonLazyObject getInstance() {
        if (instance == null) {
            instance = new SingletonLazyObject();
        }
        return instance;
    }
}

/**
 * 双检锁/双重校验锁
 */
class SingletonDCL {

    private volatile static SingletonDCL instance;

    private SingletonDCL() {
    }

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}


/**
 * 登记式/静态内部类
 */
class SingletonStatic {

    private static class SingletonHolder {

        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    private SingletonStatic() {
    }

    public static final SingletonStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }
}