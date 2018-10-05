package com.example.owner.wlt_feelsbook2;

import com.example.owner.wlt_feelsbook2.Feel;

import junit.framework.TestCase;

import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FeelsTest extends TestCase {
    public void testFeel(){
        String testComment = "I have pizza.";
        String testMood = "happy";
        Date testDate = Calendar.getInstance().getTime();
        Feel feel = new Feel(testMood, testDate, testComment);
        Assert.assertTrue("Feel mood is not equal", testMood.equals(feel.getMood()));
    }
}
