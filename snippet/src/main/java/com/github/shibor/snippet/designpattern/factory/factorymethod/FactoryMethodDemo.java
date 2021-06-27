package com.github.shibor.snippet.designpattern.factory.factorymethod;


import java.util.Scanner;

/**
 *
 * 工厂方法
 *
 * <p>
 * 一个抽象产品，一个抽象工厂
 * 添加新产品就添加新的工厂
 * 使用者需要知道新产品对于的新工厂
 * </p>
 * <p>
 * 工厂方法在简单工厂的基础上再包了一层工厂，所有的工厂都是此工厂的子类。而产生对象的类型由子类工厂决定。
 * </p>
 *
 * @author shibor
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("请输入汽车类型（Benz,Audi）：");
        Car carInstance;

        String type = in.next();
        if ("Benz".equals(type)) {
            carInstance = new BenzFactory().generateCar();
        } else if ("Audi".equals(type)) {
            carInstance = new AudiFactory().generateCar();
        } else {
            System.out.println("无法生产");
            return;
        }
        carInstance.run();
    }

}

interface CarFactory {
    Car generateCar();
}


class BenzFactory implements CarFactory {

    @Override
    public Car generateCar() {
        return new Benz();
    }
}

class AudiFactory implements CarFactory {

    @Override
    public Car generateCar() {
        return new Audi();
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
