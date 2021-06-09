package org.example.interfaces;

import java.util.ArrayList;

public abstract class Observable {
    public ArrayList<Observer> observers;
    public void add(Observer item){
        observers.add(item);
    }
    public void remove(Observer item){
        observers.remove(item);
    }
    public void alert(){
        observers.forEach(observer -> {
            observer.refresh();
            System.out.println("update");
        });
    }
}
