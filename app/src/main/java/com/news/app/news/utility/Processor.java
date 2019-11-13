package com.news.app.news.utility;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 5/25/2019.
 */

public class Processor {

    @SuppressLint("SimpleDateFormat")
    public String dateFormatterA(String dateTime) throws ParseException {

        String formattedDate;

        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = formatDate.parse(dateTime);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formattedDate = formatter.format(date);

        return formattedDate;
    }

    @SuppressLint("SimpleDateFormat")
    public String dateFormatterB(String dateInput) throws ParseException {

        String formattedDate;

        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatDate.parse(dateInput);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formattedDate = formatter.format(date);

        return formattedDate;
    }

    @SuppressLint("SimpleDateFormat")
    public static String dateFormatterC(String dateInput) throws ParseException {


        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy/MM/dd");

        Date date = formatDate.parse(dateInput);

//        Log.d("test", "MyDate: " + dateInput);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (month < 10) {
            return year + "0" + month + day;
        } else {
            return String.valueOf(year) + month + day;
        }
    }

}
