package br.edu.gedaam.service;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;

public class DateTimeServiceTest  {

    @Test
    public void convertTime() {
        Time time = DateTimeService.formatTime("13:30:00");
        Assert.assertTrue(Time.valueOf("13:30:00").getTime() == time.getTime());

    }

}