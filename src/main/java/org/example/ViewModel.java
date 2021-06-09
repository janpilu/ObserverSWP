package org.example;

import org.example.interfaces.Observable;

import java.util.ArrayList;

public class ViewModel extends Observable {
    public ViewModel(){
        observers = new ArrayList<>();
    }
}
