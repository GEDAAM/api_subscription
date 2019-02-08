package br.edu.gedaam.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {

    static public Time formatTime(String time) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat( "hh:mm:ss");
        Date date = null;
        try {
            date = timeFormatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Time(date.getTime());
    }


    static public Timestamp formatDateTime(String stringDate) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat( "dd/mm/yyyy hh:mm:ss");
        Date dateTime = null;
        try {
            dateTime = timeFormatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(dateTime.getTime());
    }

}
