package com.news.app.news.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by USER on 5/25/2019.
 */

public class Processor {

    public String dateFormatterA(String DateTime) throws ParseException {

        String FormattedDate;

        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = formatDate.parse(DateTime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        FormattedDate = formatter.format(date);

        return FormattedDate;
    }

    public String dateFormatterB(String DateInput) throws ParseException {

        String FormattedDate;

        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formatDate.parse(DateInput);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        FormattedDate = formatter.format(date);

        return FormattedDate;
    }

    public static String dateFormatterC(String DateInput) throws ParseException {


        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy/MM/dd");
        Date date = formatDate.parse(DateInput);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (month<10){
            return year + "0" + month + day;
        }else {
            return String.valueOf(year) + month + day;
        }
    }

}
