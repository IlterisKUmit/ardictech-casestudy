package com.ardic.tech.newgradproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    static String stringFormatDate = "";
    static String datePattern = "dd MMMMM yyyy";
    static String hasVowelHarmony = "";

    static List<String> dayDatesList;

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


    public static List<String> sundaysList(int startYear, int endYear){

        List<String> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

        if (startYear>endYear){

            dateList.add("End year should be greater than start year");
            return dateList;

        }else{

            for (int i = startYear; i<=endYear; i++){

                for (int j = 0; j <=11; j++){

                    calendar.set(i, j, 1);
                    int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);

                    if(day_of_week==1){

                        stringFormatDate = dateFormat.format(calendar.getTime());
                        dateList.add(stringFormatDate);
                    }
                }
            }

            return dateList;
        }
    }


    public static void main(String[] args) {

        //this should return false - ExampleWord does not have Vowel Harmony
        hasVowelHarmony = checkVowelHarmonyStatus("ExampleWord");
        System.out.println(hasVowelHarmony);

        //this should return true - NormalWord has Vowel Harmony
        hasVowelHarmony = checkVowelHarmonyStatus("NormalWord");
        System.out.println(hasVowelHarmony);

        //This should return all the sundays" dates as a list
        dayDatesList = new ArrayList<>();
        dayDatesList = sundaysList(1900, 2000);
        System.out.println(dayDatesList);

    }

}
