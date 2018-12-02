package com.example.jiayuewu.healthcarer_homepage;

public class exception_description_too_long extends Exception {
    public exception_description_too_long() {
    }

    public exception_description_too_long(String message) {
        super(message);
    }

    public exception_description_too_long(String message, Throwable throwable) {
        super(message, throwable);
    }

}
