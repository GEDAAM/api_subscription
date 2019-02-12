package br.edu.gedaam.service;

import br.edu.gedaam.util.DateTimeConverter;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;

public class DateTimeConverterTest {

    @Test
    public void convertTime() {
        Time time = DateTimeConverter.formatTime("13:30:00");
        Assert.assertTrue(Time.valueOf("13:30:00").getTime() == time.getTime());

    }

}