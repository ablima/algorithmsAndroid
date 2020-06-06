package com.example.cesarinterview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class Question6 extends JobIntentService {

    static final int JOB_ID = 1000;

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, Question6.class, JOB_ID, work);
    }

    private void PrintEmailThread(EmailMessage msg) {
        StringBuilder thread = new StringBuilder();

        while(msg != null) {
            thread.append(msg.message).append(" -> ");
            msg = msg.next;
        }

        Log.d("Question 6", thread.toString());
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        Question5 q5 = new Question5();

        EmailMessage receivedMsg = (EmailMessage) intent.getSerializableExtra("emailThread");

        Log.d("Question 6", "Received msg");
        PrintEmailThread(receivedMsg);

        q5.RemoveDuplicateOnLinkedList(receivedMsg);

        Log.d("Question 6", "Removed duplicated");
        PrintEmailThread(receivedMsg);

        Log.d("Question 6", "----------FINISHED----------");

    }

}
