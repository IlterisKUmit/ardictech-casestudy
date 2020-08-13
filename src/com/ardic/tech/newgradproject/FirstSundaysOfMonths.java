package com.ardic.tech.newgradproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstSundaysOfMonths {

    public static int[] nonLeapMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int[] leapMonths =    {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static Map<Integer, String> monthsMap = new HashMap<>();

    public static boolean isLeapYear(int year) {

        if (year % 4 == 0) {

            return true;
        }

        return false;
    }

    public static Map<Integer, String> generateMonthsMap() {

        monthsMap.put(0, "January");
        monthsMap.put(1, "February");
        monthsMap.put(2, "March");
        monthsMap.put(3, "April");
        monthsMap.put(4, "May");
        monthsMap.put(5, "June");
        monthsMap.put(6, "July");
        monthsMap.put(7, "August");
        monthsMap.put(8, "September");
        monthsMap.put(9, "October");
        monthsMap.put(10, "November");
        monthsMap.put(11, "December");

        return monthsMap;
    }

    public static List<String> sundaysInGivenYearPeriod(int startYear, int endYear){

        int[] monthsArray;
        boolean isSundayFound = false;
        int dayCounter = 0;
        String monthName= "";
        String errorMessage = "";

        List<String> sundaysList = new ArrayList<>();

        generateMonthsMap();

        if(startYear>endYear){

            errorMessage = "ERROR MESSAGE : Start year should " +
                           "be smaller than End year... " +
                           "Given Start Year : " + startYear +
                           " , Given End Year : " + endYear;

            sundaysList.add(errorMessage);

            return sundaysList;
        }

        if(monthsMap.isEmpty()){

            errorMessage = "ERROR MESSAGE : Month Map is empty, please contact admin";

            sundaysList.add(errorMessage);

            return sundaysList;
        }

        for (int i = startYear; i <= endYear; i++) {

            monthsArray = isLeapYear(i) ? leapMonths : nonLeapMonths;

            for (int j = 0; j < monthsArray.length; j++) {

                if (isSundayFound == true){

                    monthName = monthsMap.get(j);
                    sundaysList.add(monthName + " 1st - " +  i);
                    isSundayFound = false;
                }

                dayCounter += monthsArray[j] + 1;

                if (dayCounter % 7 == 1){

                    isSundayFound = true;
                }

                dayCounter--;
            }
        }

        return sundaysList;
    }

    public static void main(String[] args) {

        List<String> sundaysResultList = sundaysInGivenYearPeriod(1900, 2000);
        System.out.println("Sundays appear in first day of months : \n" + sundaysResultList);
        System.out.println(sundaysResultList.size());

    }
}
