package com.example.cesarinterview;

import android.util.Log;

import java.io.Console;

public class Question1 {

    public char[] ReplaceBlankSpaces(char[] message, int size) {
        int iMessage = 0, iResult = 0;

        char[] result = new char[10000];

        while(iMessage < size) {
            if(message[iMessage] == ' ') {
                result[iResult] = '&';
                result[iResult+1] = '3';
                result[iResult+2] = '2';

                iResult += 3;
            } else {
                result[iResult] = message[iMessage];
                iResult++;
            }

            iMessage++;
        }

        return result;
    }

    public void RunQuestion1Example(){
        char[] example = "User is not allowed      ".toCharArray();

        Log.d("Question 1", new String( ReplaceBlankSpaces(example, 19) ).trim() );
        Log.d("Question 1", "----------FINISHED----------");
    }

}
