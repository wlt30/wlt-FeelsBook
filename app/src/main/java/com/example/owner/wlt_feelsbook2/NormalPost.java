package com.example.owner.wlt_feelsbook2;

import java.util.Date;

public class NormalPost extends Feel {
    public NormalPost(String mood, Date date, String comment){
        super(mood, date, comment);
    }
    public NormalPost(String mood){
        super(mood);
    }
}
