package com.github.shibor.snippet.designpattern.command;

/**
 * <h>命令模式</h>
 *
 * @author shibor
 */
public class CommandDemo {

    public static void main(String[] args) {

        Invoker invoker = new Invoker(new MyCommand(new Receiver()));
        invoker.action();
    }
}


interface Command {
    void execute();
}

class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}

class Receiver {
    public void action() {
        System.out.println("command received!");
    }
}

class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}

