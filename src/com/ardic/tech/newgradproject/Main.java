package com.ardic.tech.newgradproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    static boolean isVowelHarmonyExisted = false;
    static List<String> mondayDatesList;
    static String stringFormatDate = "";
    static String datePattern = "dd MMMMM yyyy";
    static int i;

    public static boolean checkVowelHarmonyStatus(String inputWord){

        List<Character> charList = new ArrayList<>();

        for (i = 0; i < inputWord.length(); i++) {
            charList.add(inputWord.charAt(i));
        }

        if(( charList.contains('e') ||
             charList.contains('i') ||
             charList.contains('ü') ||
             charList.contains('ö'))
             && (
             charList.contains('a') ||
             charList.contains('ı') ||
             charList.contains('u') ||
             charList.contains('o'))
        ){
            return false;
        }
        return true;
    }


    public static List<String> mondaysList(){

        List<String> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);

        for (int i = 1900; i<=2000; i++){
            for (int j = 0; j <=11; j++){
                calendar.set(i, j, 1);
                int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
                if(day_of_week==1){
                    //add current date to list
                    stringFormatDate = dateFormat.format(calendar.getTime());
                    dateList.add(stringFormatDate);
                }
            }
        }
        return dateList;
    }


    public static void main(String[] args) {

        //this should return false - ExampleWord
        isVowelHarmonyExisted = checkVowelHarmonyStatus("ExampleWord");
        System.out.println("ExampleWord" + " has Vowel Harmony : " + isVowelHarmonyExisted);

        //this should return true - NormalWord
        isVowelHarmonyExisted = checkVowelHarmonyStatus("NormalWord");
        System.out.println("NormalWord" + " has Vowel Harmony : " + isVowelHarmonyExisted);

        //This should return all the sundays' dates as a list
        mondayDatesList = new ArrayList<>();
        mondayDatesList = mondaysList();
        System.out.println(mondayDatesList);

    }

}
