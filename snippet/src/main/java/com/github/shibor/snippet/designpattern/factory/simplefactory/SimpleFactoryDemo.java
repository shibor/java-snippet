package com.github.shibor.snippet.designpattern.factory.simplefactory;

import java.util.Scanner;

/**
 * <h>简单工厂模型</h>
 * <p>
 * 简单工厂模式又叫<b>静态工厂方法模式</b>（Static FactoryMethod Pattern）,
 * 是通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 * </p>
 * <p>
 * 实际项目中可以使用配置文件加反射的方式改进。
 * </p>
 *
 * @author shibor
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入汽车类型（Benz,Audi）：");
        Car carInstance = CarFactory.getCarInstance(in.next());
        carInstance.run();
    }


}


class CarFactory {
    public static Car getCarInstance(String type) {

        if ("Benz".equals(type)) {
            return new Benz();
        } else if ("Audi".equals(type)) {
            return new Audi();
        } else {
            System.out.println("无法生产");
            return null;
        }
    }

}


interface Car {
    void run();
}

class Benz implements Car {
    @Override
    public void run() {
        System.out.println("Benz run!");
    }
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("audi run");
    }
}