package com.example.owner.wlt_feelsbook2;

import com.example.owner.wlt_feelsbook2.Feel;
import com.example.owner.wlt_feelsbook2.FeelsList;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Collection;

public class FeelsListTest extends TestCase {
    public void testEmptyFeelsList(){
        FeelsList feelsList = new FeelsList();
        assertTrue("Empty Feels List", feelsList.count()==0);
    }

    public void testAddFeelsList(){
        FeelsList feelsList = new FeelsList();
        Feel testFeel = new Feel("sad", Calendar.getInstance().getTime(), "No comment");
        feelsList.add(testFeel);
        assertTrue("Empty Feels List", feelsList.count()==1);
    }
}
