package com.example.owner.wlt_feelsbook2;

import java.util.ArrayList;
import java.util.Date;

public abstract class Feel extends Object implements Postable, MyObservable {
    private String text;
    //private String mood
    //want to have a mood that's chosen from the list of available moods
    protected Date date;

    public Feel(String feel, Date date) throws FeelTooLongException{
        this.setText(feel);
        this.date = date;
    }

    public String getText() {return text;}

    public void setText(String text) throws FeelTooLongException{
        if (text.length() <=100) {
            this.text = text;
        } else{
            throw new FeelTooLongException();
        }
        notifyAllObservers();
    }

    public Date getDate() {return date;}

    public void setDate(Date date) {
        this.date = date;
        notifyAllObservers();
    }
    @Override
    public String toString() {
        return date.toString() + "\n" + text;
    }

    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers(){
        for (MyObserver observer : observers){
            observer.myNotify(this);
        }
    }

}
