package com.example.cesarinterview;
import android.util.Log;

import java.util.HashSet;

public class Question5 {

    public EmailMessage RemoveDuplicateOnLinkedList(EmailMessage msg) {

        //Use hashset to easily identify if the message its already been on thread
        HashSet<String> hash = new HashSet<>();

        EmailMessage currentMsg = msg;
        EmailMessage previousMsg = null;

        while( currentMsg != null){
            String message = currentMsg.message;

            if(hash.contains(message) && previousMsg != null) {
                previousMsg.next = currentMsg.next;
            } else {
                hash.add(message);
                previousMsg = currentMsg;
            }

            currentMsg = currentMsg.next;
        }

        return msg;
    }

    private void PrintEmailThread(EmailMessage msg) {
        StringBuilder thread = new StringBuilder();

        while(msg != null) {
            thread.append(msg.message).append(" -> ");
            msg = msg.next;
        }

        Log.d("Question 5", thread.toString());
    }

    public void RunQuestion5example() {

        EmailMessage thread = new EmailMessage("email message 10");

        thread.next = new EmailMessage("email message 12");
        thread.next.next = new EmailMessage("email message 11");
        thread.next.next.next = new EmailMessage("email message 11");
        thread.next.next.next.next = new EmailMessage("email message 12");
        thread.next.next.next.next.next = new EmailMessage("email message 11");
        thread.next.next.next.next.next.next = new EmailMessage("email message 10");

        PrintEmailThread(thread);

        EmailMessage result = RemoveDuplicateOnLinkedList(thread);

        PrintEmailThread(result);

        Log.d("Question 5", "----------FINISHED----------");
    }

}

