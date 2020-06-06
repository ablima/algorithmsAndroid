package com.example.cesarinterview;

import android.util.Log;

public class Question2 {

    public Boolean isJumbledLetters(String text1, String text2)
    {
        if(text1.charAt(0) != text2.charAt(0) || text1.length() != text2.length()) {
            return false;
        }

        int errorCount = 0;
        long maxErrors = Math.round( text1.length() * (2.0 / 3.0) );

        for(int i=0; i < text1.length(); i++) {
            if(text1.charAt(i) != text2.charAt(i)) {        //Check if the letters are the same
                if( !text2.contains( String.valueOf(text1.charAt(i)) ) ) {    //If not, check if the letter is in another place
                    return false;
                }

                errorCount++;

                if(text1.length() > 3 && errorCount > maxErrors ){
                    return false;
                }

            }
        }

        return true;
    }

    public void RunQuestion2Example(){
        String text1 = "you";
        String text2 = "yuo";

        Log.d("Question 2 - 1", isJumbledLetters(text1, text2).toString() );

        text1 = "probably";
        text2 = "porbalby";

        Log.d("Question 2 - 2", isJumbledLetters(text1, text2).toString() );

        text1 = "despite";
        text2 = "desptie";

        Log.d("Question 2 - 3", isJumbledLetters(text1, text2).toString() );

        text1 = "moon";
        text2 = "nmoo";

        Log.d("Question 2 - 4", isJumbledLetters(text1, text2).toString() );

        text1 = "misspellings";
        text2 = "mpeissngslli";

        Log.d("Question 2 - 5", isJumbledLetters(text1, text2).toString() );
        Log.d("Question 2", "----------FINISHED----------");
    }

}
