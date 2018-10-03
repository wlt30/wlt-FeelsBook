package com.example.owner.wlt_feelsbook2;

import java.util.Date;

public abstract class Feel extends Object implements Postable {
    private String text;
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


    private void notifyAllObservers(){
        for (MyObserver observer : observers){
            observer.myNotify(observable: this);
        }
    }

}
