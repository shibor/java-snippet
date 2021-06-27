package com.github.shibor.snippet.designpattern.bridge;

/**
 * 桥接模式
 * 把 is-a 转换成 has-a 关系
 * 类只有一个改变它的原因
 * 例子中，颜色和形状的修改都不需要修改原来的代码，开闭原则
 *
 * @author shibor
 */
public class BridgeDemo {
    public static void main(String[] args) {

        Color white = new WhiteColor();

        //白色的正方形
        Shape square = new Square();
        square.setColor(white);
        square.draw();

        //白色的圆形
        Shape circle = new Circle();
        circle.setColor(white);
        circle.draw();

    }
}


abstract class Shape {

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();

    public Color getColor() {
        return color;
    }
}


interface Color {
    void drawColor();
}


class Circle extends Shape {
    @Override
    public void draw() {
        getColor().drawColor();
        System.out.println("圆形...");
    }
}

class Square extends Shape {

    @Override
    public void draw() {
        getColor().drawColor();
        System.out.println("正方形...");
    }
}


class WhiteColor implements Color {
    @Override
    public void drawColor() {
        System.out.print("白色的");
    }
}

class RedColor implements Color {
    @Override
    public void drawColor() {
        System.out.print("红色的");
    }
}