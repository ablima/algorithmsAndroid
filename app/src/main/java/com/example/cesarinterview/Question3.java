package com.example.cesarinterview;

import android.util.Log;

public class Question3 {

    public Boolean CheckWordTypo(String text1, String text2){

        //If words length are too much different, assume it have more than 2 typos
        if(text1.length() < text2.length() - 2 || text1.length() > text2.length() + 1){
            return false;
        }

        int numTypos = 0;

        int iText1 = 0;
        int iText2 = 0;

        while(iText1 < text1.length()) {

            if(text1.charAt(iText1) != text2.charAt(iText2)) {

                numTypos++;

                boolean shouldIncrementText2 = true;

                if( (iText1+1 < text1.length() && text1.charAt(iText1+1) == text2.charAt(iText2)) ||   //REMOVED CHARACTER TYPO
                    (iText2 != 0 && text1.charAt(iText1) == text2.charAt(iText2-1)) ) { // INSERT CHARACTER TYPO
                    shouldIncrementText2 = false;
                }

                //If not, was a REPLACE CHARACTER TYPO

                iText1++;
                if(iText2+1 < text2.length() && shouldIncrementText2){
                    iText2++;
                }

            }else{
                iText1++;
                if(iText2+1 < text2.length()) {
                    iText2++;
                }
            }

        }

        if(iText1 < text2.length()) {
            numTypos += text2.length() - iText1;
        }

        return numTypos <= 1;
    }

    public void RunQuestion3Example(){
        String text1 = "pale";
        String text2 = "ple";

        Log.d("Question 3 - 1", CheckWordTypo(text1, text2).toString() );

        text1 = "pales";
        text2 = "pale";

        Log.d("Question 3 - 2", CheckWordTypo(text1, text2).toString() );

        text1 = "pale";
        text2 = "bale";

        Log.d("Question 3 - 3", CheckWordTypo(text1, text2).toString() );

        text1 = "pale";
        text2 = "bake";

        Log.d("Question 3 - 4", CheckWordTypo(text1, text2).toString() );
        Log.d("Question 3", "----------FINISHED----------");
    }

}
