package com.example.cesarinterview;

import java.io.Serializable;

public class EmailMessage implements Serializable {

    String message;
    EmailMessage next;

    EmailMessage(String msg) {
        message = msg;
    }

}
