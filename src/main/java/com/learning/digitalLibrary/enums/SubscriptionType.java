package com.learning.digitalLibrary.enums;

// In enums by default it save the types in integer as sequence from 0 - n-1.
// The issue here is if someone need to add more type and by mistake that user add in between then it will change the whole scenario.
// To prevent this we can save the String as it is by using @Enumerated(value = EnumType.STRING)

import lombok.Getter;

@Getter
public enum SubscriptionType {

    NOT_SUBSCRIBED("Not Subscribed",0 ),
    PLUS("Plus", 3),
    PRO("Pro",7),
    PREMIUM("premium",14);

    private final String name;
    private final int allowance;

    SubscriptionType(String name, int allowance){
        this.name = name;
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
