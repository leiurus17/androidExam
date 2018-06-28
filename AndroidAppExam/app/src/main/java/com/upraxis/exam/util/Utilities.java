package com.upraxis.exam.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by killersmile on 10/05/2018.
 */

public class Utilities {

    public static final String TAG = Utilities.class.getSimpleName();


    // Parameter E.g. 01-01-1972
    public static Date ConvertStringToDate(String date){

        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date toDateFormat = null;
        try {
            toDateFormat = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toDateFormat;
    }


    // Parementer time stamp milliseconds
    public static String ConvertTimeStampToStringDate(String timeStampMilliSeconds){

        DateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Date toDateFormat = (new Date(Long.parseLong(timeStampMilliSeconds)));

        return sdf.format(toDateFormat);
    }

    // Parementer time stamp milliseconds
    public static int computeAge(String timeStampMilliSeconds){

        Calendar bdayCal = Calendar.getInstance();
        bdayCal.setTimeInMillis(Long.parseLong(timeStampMilliSeconds));

        Calendar todayCal = Calendar.getInstance();
        int age = todayCal.get(Calendar.YEAR) - bdayCal.get(Calendar.YEAR);
        if (todayCal.get(Calendar.DAY_OF_YEAR) < bdayCal.get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;
    }
}
