package com.example.jiayuewu.healthcarer_homepage;

public class exception_titleTooLong extends Exception{
    public exception_titleTooLong() {
    }

    public exception_titleTooLong(String message) {
        super(message);
    }

    public exception_titleTooLong(String message, Throwable throwable) {
        super(message, throwable);
    }
}
