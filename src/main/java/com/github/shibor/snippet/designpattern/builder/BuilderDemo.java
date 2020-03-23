package com.github.shibor.snippet.designpattern.builder;

/**
 * <h>
 * 构建者模式
 * </h>
 * <p>
 * Builder：生成器接口，定义创建一个Product对象所需的各个部件的操作。
 * <br/>
 * ConcreteBuilder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，提供获取产品对象的方法。
 * <br/>
 * Director：统一组装过程
 * <br/>
 * Product：产品，表示被生成器构建的复杂对象，包含多个部件。
 * </p>
 *
 * @author shibor
 */
public class BuilderDemo {

    public static void main(String[] args) {
        Director director = new Director(new HPComputerBuilder());
        director.constructComputer();
        Computer pc = director.getComputer();

    }

}


class Computer {
    public String master;
    public String screen;
    public String keyboard;
    public String mouse;
    public String audio;

    public void setMaster(String master) {
        this.master = master;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}


abstract class ComputerBuilder {

    protected Computer computer;

    public void buildComputer() {
        computer = new Computer();
        System.out.println("生成了一台电脑！！！");
    }

    public Computer getComputer() {
        return computer;
    }

    public abstract void buildMaster();

    public abstract void buildScreen();

    public abstract void buildKeyboard();

    public abstract void buildMouse();

    public abstract void buildAudio();
}


class HPComputerBuilder extends ComputerBuilder {

    @Override
    public void buildMaster() {
        computer.setMaster("i7,16g,512SSD,1060");
        System.out.println("(i7,16g,512SSD,1060)的惠普主机");
    }

    @Override
    public void buildScreen() {
        computer.setScreen("1080p");
        System.out.println("(1080p)的惠普显示屏");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("cherry 青轴机械键盘");
        System.out.println("(cherry 青轴机械键盘)的键盘");
    }

    @Override
    public void buildMouse() {
        computer.setMouse("MI 鼠标");
        System.out.println("(MI 鼠标)的鼠标");
    }

    @Override
    public void buildAudio() {
        computer.setAudio("飞利浦 音响");
        System.out.println("(飞利浦 音响)的音响");
    }
}

class DELLComputerBuilder extends ComputerBuilder {


    @Override
    public void buildMaster() {
        computer.setMaster("i7,32g,1TSSD,1060");
        System.out.println("(i7,32g,1TSSD,1060)的戴尔主机");
    }

    @Override
    public void buildScreen() {
        computer.setScreen("4k");
        System.out.println("(4k)的dell显示屏");
    }

    @Override
    public void buildKeyboard() {
        computer.setKeyboard("cherry 黑轴机械键盘");
        System.out.println("(cherry 黑轴机械键盘)的键盘");
    }

    @Override
    public void buildMouse() {
        computer.setMouse("MI 鼠标");
        System.out.println("(MI 鼠标)的鼠标");
    }

    @Override
    public void buildAudio() {
        computer.setAudio("飞利浦 音响");
        System.out.println("(飞利浦 音响)的音响");
    }


}

class Director {

    private ComputerBuilder computerBuilder;

    public Director(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.buildComputer();
        computerBuilder.buildMaster();
        computerBuilder.buildScreen();
        computerBuilder.buildKeyboard();
        computerBuilder.buildMouse();
        computerBuilder.buildAudio();
    }

}