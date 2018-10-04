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
        FeelsList anotherFeelsList = new FeelsList();
        Feel testFeel = new Feel("sad", Calendar.getInstance().getTime(), "No comment");
        anotherFeelsList.add(testFeel);
        assertTrue("List size not 1", anotherFeelsList.count()==1);
        assertTrue("feelsList does not contain testcase", anotherFeelsList.contains(testFeel));
    }

    public void testRemoveFeelsList(){
        FeelsList anotherFeelsList = new FeelsList();
        Feel testFeel = new Feel("sad", Calendar.getInstance().getTime(), "No comment");
        anotherFeelsList.add(testFeel);
        assertTrue("Non-Empty Feels List", anotherFeelsList.count()==1);
        assertTrue("feelsList contains test", anotherFeelsList.contains(testFeel));
        anotherFeelsList.remove(testFeel);
        assertTrue("List not empty", anotherFeelsList.count()==0);
        assertFalse("feelsList still contains testcase", anotherFeelsList.contains(testFeel));
    }
}
