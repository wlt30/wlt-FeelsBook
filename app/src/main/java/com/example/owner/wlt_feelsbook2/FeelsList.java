package com.example.owner.wlt_feelsbook2;
/* FeelsList is an array of Feels objects and is displayed using a ListView in the activity_main.xml layout. This class includes functions for adding, removing, counting and checking for a specified Feel. The count method would be modified to be able to search for all entries of a given mood and return and integer count.
 */
import java.util.ArrayList;
import java.util.Collection;

public class FeelsList implements MyObservable, MyObserver{
    private Feel mostRecentFeel;
    private ArrayList<Feel> feels;

    public void add(Feel feel){
        this.mostRecentFeel = feel;
        feels.add(feel);
        feel.addObserver(this);
        notifyAllObservers();
    }

    public void remove(Feel feel){
        feels.remove(feel);
    }
    public Feel getMostRecentFeel() {
        return mostRecentFeel;
    }
    public int count(){
        return (feels.size());
    }

    public Boolean contains(Feel feel){
        return (feels.contains(feel));
    }
    public Collection<Feel> getFeels() {
        return this.feels;
    }

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
