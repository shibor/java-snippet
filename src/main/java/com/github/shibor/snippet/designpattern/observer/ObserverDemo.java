package com.github.shibor.snippet.designpattern.observer;

import java.util.ArrayList;

/**
 * <h>观察者模式</h>
 * 一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知
 *
 * @author shibor
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Observer ob1 = new Observer1();
        Observer ob2 = new Observer2();

        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(ob1);
        subject.attach(ob2);

        subject.setSubjectState(1);
    }
}


class ConcreteSubject implements Subject {
    private ArrayList<Observer> obervers = new ArrayList<>();
    private int subjectState;

    public int getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(int subjectState) {
        if (this.subjectState != subjectState) {
            notifyObervers();
        }
        this.subjectState = subjectState;
    }

    @Override
    public void attach(Observer oberver) {
        obervers.add(oberver);
    }

    @Override
    public void detach(Observer oberver) {
        obervers.remove(oberver);
    }

    @Override
    public void notifyObervers() {
        for (Observer item : obervers) {
            System.out.println("通知观察者");
            item.update();
        }
    }
}

interface Subject {

    void attach(Observer oberver);

    void detach(Observer oberver);

    void notifyObervers();
}


interface Observer {
    void update();
}

class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("观察者1更新");
    }
}

class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("观察者2更新");
    }
}