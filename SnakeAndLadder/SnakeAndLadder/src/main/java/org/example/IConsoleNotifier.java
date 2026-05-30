package org.example;

public class IConsoleNotifier implements IObserver{

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}
