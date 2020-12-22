package com.company;

public interface BaseInterestRate {
    // both accounts will use an interface that determines the base interest rate

    default double baseInterestRate(){
        return 2.5;
    }
    


}
