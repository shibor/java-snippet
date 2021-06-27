package com.github.shibor.snippet.designpattern.decorator;

/**
 * 装饰器模式
 * 1、扩展一个类的功能。 2、动态增加功能
 *
 * @author shibor
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
        decoratorA.sampleOpreation();
        decoratorA.behaviorA();
    }
}

interface Component {
    void sampleOpreation();
}

class ConcreteComponent implements Component {
    @Override
    public void sampleOpreation() {
        System.out.println("ConcreteComponent sampleOpreation!");
    }
}


class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOpreation() {
        component.sampleOpreation();
    }
}


class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOpreation() {
        System.out.println("ConcreteDecoratorA");
        super.sampleOpreation();
    }

    public void behaviorA() {
        System.out.println("behaviorA");
    }
}

class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOpreation() {
        System.out.println("ConcreteDecoratorB");
        super.sampleOpreation();
    }

    public void behaviorB() {
        System.out.println("behaviorB");
    }
}