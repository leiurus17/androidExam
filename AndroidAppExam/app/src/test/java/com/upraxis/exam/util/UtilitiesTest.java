package com.upraxis.exam.util;

import org.junit.Test;

public class UtilitiesTest {

    @Test
    public void ConvertStringToDate(){
        String date = "01-01-1981";
        System.out.println("Test ConvertStringToDate " + Utilities.ConvertStringToDate(date));
    }

    @Test
    public void ConvertTimeStampToStringDate(){
        String epochTime = "709699696000";
        System.out.println("Test ConvertTimeStampToStringDate " + Utilities.ConvertTimeStampToStringDate(epochTime));
    }

    @Test
    public void ComputeAge(){
        String epochTime = "709699696000";
        System.out.println("Test ComputeAge " + Utilities.computeAge(epochTime));
    }




}
