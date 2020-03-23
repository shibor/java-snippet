package com.github.shibor.snippet.designpattern.adapter;

/**
 * 目标（Target）：定义一个客户端使用的特定接口。
 * <p>
 * 客户端（Client）：使用目标接口，与和目标接口一致的对象合作。
 * <p>
 * 被适配者（Adaptee）：一个现存需要适配的接口。
 * <p>
 * 适配器（Adapter）：负责将Adaptee的接口转换为Target的接口。适配器是一个具体的类，这是该模式的核心。
 */
public class AdapterDemo {

    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.operate();

        Target target1 = new ObjectAdapter(new Adaptee());
        target1.operate();
    }
}


/**
 * 被适配类
 */
class Adaptee {

    public void adaptedOperation() {
        System.out.println("220V 的电源");
    }
}


/**
 * 定义适配器的功能  目标类
 */
interface Target {

    void operate();
}


/**
 * 适配器 (类适配器方式)
 */
class ClassAdapter extends Adaptee implements Target {

    @Override
    public void operate() {
        System.out.println("适配器做些适配操作");
        super.adaptedOperation();
    }
}

/**
 * 对象适配器
 */
class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void operate() {
        System.out.println("适配器做些适配操作");
        this.adaptee.adaptedOperation();
    }
}
