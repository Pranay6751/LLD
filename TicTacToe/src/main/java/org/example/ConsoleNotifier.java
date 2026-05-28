package org.example;
import java.util.*;
class ConsoleNotifier implements IObserver{

    //in app notifications
    //observer pattern
    @Override
    public void update(String msg) {
        System.out.println("[Notification] "+msg);
    }
}
