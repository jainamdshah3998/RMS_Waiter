package com.example.waiterside.Constants;

public class Validation {
    public static boolean isEmpty(String s)
    {
        if(s.trim().length() == 0)
        {
            return true;
        }
        return false;
    }
}