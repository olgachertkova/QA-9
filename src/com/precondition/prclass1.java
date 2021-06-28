package com.precondition;

import org.testng.annotations.Test;

public class prclass1 {
    @Test(priority = 2)
    public void precontest11(){
        System.out.println("precontest11");
    }
    @Test(priority = 2)
    public void precontest12(){
        System.out.println("precontest12");
    }
}
