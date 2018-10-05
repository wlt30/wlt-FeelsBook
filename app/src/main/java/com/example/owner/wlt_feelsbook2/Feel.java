package com.example.owner.wlt_feelsbook2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Feel extends Object implements MyObservable {
    protected String comment;
    protected String mood;
    protected Date date; //this was protected before, but we want it to be editable

    public Feel(String mood, Date date, String comment) throws FeelTooLongException{
        this.setMood(mood);
        this.date = date;
        this.comment = comment;
    }

    public String getComment() {return comment;}
    public String getMood() {return mood;}
    public Date getDate() { return date; }

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
        Date testDate = this.date;
        DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        String newDate = dformat.format(new Date());
        return newDate + " You felt " + mood +":\n" + comment;
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
