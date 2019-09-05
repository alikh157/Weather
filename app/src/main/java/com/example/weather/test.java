package com.example.weather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    double temp;
    String DayName, icon, time;

    public test(double temp, String DayName, String icon, String time) {
        String day;
        this.temp = temp;
        this.time = time;
        long unixSeconds3 = Long.parseLong(time);
// convert seconds to milliseconds
        Date date3 = new java.util.Date(unixSeconds3 * 1000L);
// the format of your date
        SimpleDateFormat sdf3 = new java.text.SimpleDateFormat("E");
// give a timezone reference for formatting (see comment at the bottom)
        sdf3.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
        day = sdf3.format(date3);
        this.DayName = day;
        this.icon = icon;
    }

}
