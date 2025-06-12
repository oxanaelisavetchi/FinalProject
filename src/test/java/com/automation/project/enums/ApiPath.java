package com.automation.project.enums;

import lombok.Getter;

@Getter
public enum ApiPath {

    // GET
    USERS("users"),
    USERS_PAGE("users?page=2"),
    UNKNOWN("unknown"),
    UNKNOWN_2("unknown/2"),
    UNKNOWN_23("unknown/23"),
    USERS_DELAY("users?delay=3"),

    // Specific ID
    USERS_ID("users/2"),

    // POST
    REGISTER("register"),
    LOGIN("login");

    private final String path;

    ApiPath(String path) {
        this.path = path;
    }
}
