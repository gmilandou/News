package com.news.app.news.utility;

import com.news.app.news.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

}
