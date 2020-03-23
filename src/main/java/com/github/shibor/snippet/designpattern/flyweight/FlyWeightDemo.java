package com.github.shibor.snippet.designpattern.flyweight;

import java.util.HashMap;

/**
 * <h>享元模型</h>
 */
public class FlyWeightDemo {

    public static void main(String[] args) {
        FlyWeight flyWeight = FlyWeightFactory.getFlyWeight(0);
        flyWeight.operation();
    }
}

/**
 * cache
 */
class FlyWeightFactory {

    private static HashMap<Integer, FlyWeight> cache = new HashMap<Integer, FlyWeight>();

    public static FlyWeight getFlyWeight(int key) {

        FlyWeight flyWeight = cache.get(key);
        if (flyWeight == null) {
            flyWeight = new ConcreteFlyweight();
            cache.put(key, flyWeight);
        }
        return flyWeight;
    }
}

interface FlyWeight {
    
    void operation();
}

class ConcreteFlyweight implements FlyWeight {

    @Override
    public void operation() {
        System.out.println("ConcreteFlyweight");
    }
}