package com.learning.digitalLibrary.enums;

public enum SubscriptionType {

    NOT_SUBSCRIBED("Not Subscribed"),
    PLUS("Plus"),
    PRO("Pro"),
    PREMIUM("premium    ");

    private String name;

    SubscriptionType(String name){
        this.name = name;
    }


}
