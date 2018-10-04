package com.example.owner.wlt_feelsbook2;

import java.util.ArrayList;

public class FeelsList implements MyObservable, MyObserver{
    private Feel mostRecentFeel;
    private ArrayList<Feel> feels = new ArrayList<>();

    public void add(Feel feel){
        mostRecentFeel = feel;
        feels.add(feel);
        feel.addObserver(this);
        notifyAllObservers();
    }

    public Feel getMostRecentFeel(){
        return mostRecentFeel;
    }

    public int count(){return feels.size();}
    private volatile ArrayList<MyObserver> observers = new ArrayList<>();

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }
    private void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable){
        notifyAllObservers();
    }
}
