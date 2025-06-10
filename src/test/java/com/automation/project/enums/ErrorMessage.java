package com.automation.project.enums;

import lombok.Getter;



@Getter
public enum ErrorMessage {
    USERNAME_REQUIRED("Epic sadface: Username is required"),
    PASSWORD_REQUIRED("Epic sadface: Password is required"),
    INVALID_CREDENTIALS("Epic sadface: Username and password do not match any user in this service"),
    LOCKED_OUT_USER("Epic sadface: Sorry, this user has been locked out.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}