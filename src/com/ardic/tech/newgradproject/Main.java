package com.ardic.tech.newgradproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    static String datePattern = "dd MMMMM yyyy";
    static String stringFormatDate = "";
    static String hasVowelHarmony = "";

    public static String checkVowelHarmonyStatus(String inputWord) {

        if (inputWord.contains(" ") || inputWord.isEmpty()){

            return inputWord + " : Please give a proper word";

        }else if(( inputWord.contains("e") ||
                   inputWord.contains("i") ||
                   inputWord.contains("ü") ||
                   inputWord.contains("ö"))
                   && (
                   inputWord.contains("a") ||
                   inputWord.contains("ı") ||
                   inputWord.contains("u") ||
                   inputWord.contains("o"))){

            return inputWord + " : does not have Vowel Harmony.";
        }
        
        return inputWord + " : has Vowel Harmony.";
    }


    public static List<String> findFirstSundaysOfMonthsFirstDay(int startYear, int endYear){

        List<String> dateOfStrList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

        if (startYear>endYear){

            dateOfStrList.add("End year should be greater than start year");
            return dateOfStrList;

        }else{

            for (int i = startYear; i<=endYear; i++){

                for (int j = 0; j <=11; j++){

                    calendar.set(i, j, 1);
                    int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

                    if(day_of_week==1){

                        stringFormatDate = dateFormat.format(calendar.getTime());
                        dateOfStrList.add(stringFormatDate);
                    }
                }
            }

            return dateOfStrList;
        }
    }


    public static void main(String[] args) {

        //this should return false - ExampleWord does not have Vowel Harmony
        hasVowelHarmony = checkVowelHarmonyStatus("ExampleWord");
        System.out.println(hasVowelHarmony);

        //this should return true - NormalWord has Vowel Harmony
        hasVowelHarmony = checkVowelHarmonyStatus("NormalWord");
        System.out.println(hasVowelHarmony);

        //this should return true - AnotherWord does not have Vowel Harmony
        hasVowelHarmony = checkVowelHarmonyStatus("AnotherWord");
        System.out.println(hasVowelHarmony);

        //This should return all the sundays between dates 1900 - 2000
        List<String> sundayDatesList1 = findFirstSundaysOfMonthsFirstDay(1900, 2000);
        System.out.println(sundayDatesList1);

        //This should return all the sundays between dates 1960 - 2000
        List<String> sundayDatesList2 = findFirstSundaysOfMonthsFirstDay(1960, 2000);
        System.out.println(sundayDatesList2);

        //This should return all the sundays between dates 2001 - 2019
        List<String> sundayDatesList3 = findFirstSundaysOfMonthsFirstDay(2001, 2019);
        System.out.println(sundayDatesList3);

    }

}
