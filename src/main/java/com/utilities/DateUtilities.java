package com.utilities;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * General date helper utilities
 */
public class DateUtilities {
    public static String fixUTCDateToString(String expirationDate){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.format(formatter.parse(expirationDate + 'Z'));
        }
        catch(ParseException exception)
        {
            return new Date().toString();
        }
    }

    public static Date fixUTCDate(String expirationDate){
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(expirationDate + 'Z');
        }
        catch(ParseException exception)
        {
            return new Date();
        }
    }
}
