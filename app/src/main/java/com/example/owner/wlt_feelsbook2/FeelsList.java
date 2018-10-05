package com.example.owner.wlt_feelsbook2;

import java.util.ArrayList;
import java.util.Collection;

public class FeelsList implements MyObservable, MyObserver{
    /*protected Feel mostRecentFeel;*/
    protected ArrayList<Feel> feels;

    public FeelsList(){
        feels = new ArrayList<>();
    }

    public void add(Feel feel){
        /*this.mostRecentFeel = feel;*/
        feels.add(feel);
        feel.addObserver(this);
        notifyAllObservers();
    }
    public void remove(Feel feel){
        feels.remove(feel);
    }
    /*public Feel getMostRecentFeel(){
        return mostRecentFeel;
    }*/
    public int count(){return feels.size();}

    public Boolean contains(Feel feel){
        return (feels.contains(feel));
    }
    public Collection<Feel> getFeels() {
        return this.feels;
    }
    public void addObserver(MyObserver observer){
        observers.add(observer);
    }
    private void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }

    private volatile ArrayList<MyObserver> observers = new ArrayList<>();
    public void myNotify(MyObservable observable){
        notifyAllObservers();
    }
}
