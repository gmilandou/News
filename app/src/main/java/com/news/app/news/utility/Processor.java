package com.news.app.news.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by USER on 5/25/2019.
 */

public class Processor {

    public String dateFormatter(String DateTime) throws ParseException {

        String FormattedDate = null;

        SimpleDateFormat formatDate;
        formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = formatDate.parse(DateTime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        FormattedDate = formatter.format(date);

        return FormattedDate;
    }
}
