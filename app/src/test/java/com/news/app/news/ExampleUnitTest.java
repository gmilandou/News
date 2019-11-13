package com.news.app.news;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.news.app.news.utility.Processor;

import java.text.ParseException;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Processor processor = new Processor();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void positiveDateFormatterA() throws ParseException {
        String myActualDate = processor.dateFormatterA("2019-11-13T21:16:14+0000");
        assertEquals("13/11/19", myActualDate);
    }

    @Test
    public void negativeDateFormatterA() throws ParseException {
        String myActualDate = processor.dateFormatterA("2019-11-13T21:16:14+0000");
        assertNotEquals("13/11/2019", myActualDate);
    }




    @Test
    public void positiveDateFormatterB() throws ParseException {
        String myActualDate = processor.dateFormatterB("2019-11-13 00:08:57.231");
        assertEquals("13/11/19", myActualDate);
    }

    @Test
    public void negativeDateFormatterB() throws ParseException {
        String myActualDate = processor.dateFormatterB("2019-11-13 00:08:57.231");
        assertNotEquals("13/11/2019", myActualDate);
    }




    @Test
    public void positiveDateFormatterC() throws ParseException {
        String myActualDate = processor.dateFormatterC("2019/11/13");
        assertEquals("20191113", myActualDate);
    }

    @Test
    public void negativeDateFormatterC() throws ParseException {
        String myActualDate = processor.dateFormatterC("2019/11/13");
        assertNotEquals("2019/11/13", myActualDate);
    }



}

