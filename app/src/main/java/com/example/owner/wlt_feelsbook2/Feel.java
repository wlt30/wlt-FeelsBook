package com.example.owner.wlt_feelsbook2;

import java.util.ArrayList;
import java.util.Date;


public abstract class Feel extends Object implements Postable, MyObservable {
    private String comment = "(optional)";
    private String mood;
    //want to have a mood that's chosen from the list of available moods
    protected Date date;

    public Feel(String mood, Date date, String comment) throws FeelTooLongException{
        this.setComment(comment);
        this.setMood(mood);
        this.date = date;
    }

    public Feel(String mood) throws FeelTooLongException{
        this.setMood(mood);
        this.date = new Date();
    }

    public String getComment() {return comment;}
    public String getMood() {return mood;}
    public Date getDate() {return date;}

    public void setComment(String comment) throws FeelTooLongException{
        if (comment.length() <= 100) {
            this.comment = comment;
        } else{
            throw new FeelTooLongException();
        }
        notifyAllObservers();
    }

    public void setMood(String mood) throws FeelTooLongException{
            this.mood = mood;
        notifyAllObservers();
    }

    public void setDate(Date date) {
        this.date = date;
        notifyAllObservers();
    }
    @Override
    public String toString() {
        return date.toString() + " You felt " + mood +":\n" + comment;
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
