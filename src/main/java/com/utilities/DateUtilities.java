package com.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        DateFormat formatter;
        try {
            if(isUTCFormat(expirationDate)){
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.parse(expirationDate + 'Z');
            }else {
                formatter = new SimpleDateFormat("MM-dd-yyyy");
                return formatter.parse(expirationDate);
            }

        }
        catch(ParseException exception)
        {
            return new Date();
        }
    }

    public static Boolean isUTCFormat(String dateString){
        String regex = "\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1])T(?:[0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d.[0][0][0]";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(dateString);

        return matcher.find();
    }
}
