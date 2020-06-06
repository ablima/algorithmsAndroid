package com.example.cesarinterview;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Question7 {

    public EmailMessage GetIntersectNode(EmailMessage msg1, EmailMessage msg2){

        Map<String, EmailMessage> msg1Hash = new HashMap<>();

        //Put all values of first thread to easily identify the nodes when check the second thread
        while(msg1 != null){
            msg1Hash.put(msg1.message, msg1);
            msg1 = msg1.next;
        }

        //Search if have some node equal to the first thread
        //If its true, go thought the node to check if the others nodes are equals
        while(msg2 != null){
            if(msg1Hash.containsKey(msg2.message)){
                if(CheckNodesEquality(msg1Hash.get(msg2.message), msg2)){
                    return msg2;
                }
            }
            msg2 = msg2.next;
        }

        return null;
    }

    private boolean CheckNodesEquality(EmailMessage msg1, EmailMessage msg2) {
        if((msg1 != null && msg2 == null) || (msg1 == null && msg2 != null)){
            return false;
        }

        if(msg1 != null) {
            if(msg1.message.equals(msg2.message)){
                return CheckNodesEquality(msg1.next, msg2.next);
            }else{
                return false;
            }
        }

        return true;
    }

    private void PrintEmailThread(EmailMessage msg) {

        StringBuilder thread = new StringBuilder();

        while(msg != null) {
            thread.append(msg.message).append(" -> ");
            msg = msg.next;
        }

        Log.d("Question 7", thread.toString());

    }

    public void RunQuestion7Example(){

        EmailMessage thread1 = new EmailMessage("C");
        thread1.next = new EmailMessage("A");
        thread1.next.next = new EmailMessage("E");
        thread1.next.next.next = new EmailMessage("H");
        thread1.next.next.next.next = new EmailMessage("J");
        thread1.next.next.next.next.next = new EmailMessage("B");
        thread1.next.next.next.next.next.next = new EmailMessage("A");

        EmailMessage thread2 = new EmailMessage("D");
        thread2.next = new EmailMessage("F");
        thread2.next.next = new EmailMessage("J");
        thread2.next.next.next = new EmailMessage("B");
        thread2.next.next.next.next = new EmailMessage("A");

        PrintEmailThread(thread1);
        PrintEmailThread(thread2);

        EmailMessage result = GetIntersectNode(thread1, thread2);

        PrintEmailThread(result);

        Log.d("Question 7", "----------FINISHED----------");
    }

}