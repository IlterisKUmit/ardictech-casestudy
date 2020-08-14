package com.ardic.tech.newgradproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VowelHarmony {

    final static int wordCountLimitInList = 1000000;
    static String wordsStaticInput = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                                    "elit. Nulla vel varius purus. Etiam ut" +
                                    " erat dignissim, hendrerit elit a, ornare " +
                                    "tellus. In ornare auctor massa, at hendrerit leo auctor " +
                                    "sit amet. Donec ac dolor eget velit tincidunt " +
                                    "laoreet et at turpis. Proin est odio, molestie a " +
                                    "volutpat sed, ornare quis arcu. Mauris nec " +
                                    "pretium arcu. Ut blandit tortor pharetra metus aliquam " +
                                    "pretium. Nulla nisl neque, iaculis sed sagittis " +
                                    "vitae, efficitur semper ex. Nunc velit metus, pretium " +
                                    "et sapien at, faucibus aliquam ex. Duis id egestas " +
                                    "nibh. Integer lacinia scelerisque urna, eu " +
                                    "consectetur urna accumsan a. Proin gravida tellus " +
                                    "eget pellentesque vulputate. Nullam fermentum " +
                                    "viverra libero, eget feugiat metus molestie ac. " +
                                    "Donec maximus volutpat urna. Duis tortor quam, maximus" +
                                    " et nulla non, auctor tempus nunc. Nullam ac " +
                                    "magna eget augue sodales luctus. ";

    public static List<String> inputSplitter(String input){

        String [] words;
        List<String> resultList = new ArrayList<>();

        input = input.replaceAll("([.,!?:;'-])|\\s","-");
        words = input.toLowerCase().split("--|-");

        Collections.addAll(resultList, words);

        return resultList;
    }

    public static List<String> checkVowelHarmony(List<String> input){

        List<String> resultList = new ArrayList<>();

        if (input.size() > wordCountLimitInList){

            String errorMessage = "ERROR MESSAGE : Input is too long.";

            resultList.add(errorMessage);
            return resultList;
        }

        for (String nextWord : input) {

            if ((nextWord.contains("e") ||
                 nextWord.contains("i") ||
                 nextWord.contains("ü") ||
                 nextWord.contains("ö"))
                 && (
                 nextWord.contains("a") ||
                 nextWord.contains("u") ||
                 nextWord.contains("o") ||
                 nextWord.contains("ı"))) {

                resultList.add(nextWord + " : DOES NOT HAVE HARMONY");
            } else {

                resultList.add(nextWord + " : HAS HARMONY");
            }
        }

        return resultList;
    }

    public static void main(String[] args) {

        List<String> result;

        result = checkVowelHarmony(
                 inputSplitter(wordsStaticInput));
        System.out.println("Vowel Harmony Result for Given Input : \n" + result);

    }
}
