package com.automation.project.enums;

import lombok.Getter;

@Getter
public enum ApiPath {

    // GET
    USERS_ID("users/2"),
    UNKNOWN_2("unknown/2"),
    USERS_PAGE("users?page=2"),
    UNKNOWN("unknown"),
    USERS_DELAY("users?delay=3"),
    UNKNOWN_23("unknown/23"),
    USERS_23("users/23"),

    // POST
    USERS("users"),
    REGISTER("register"),
    LOGIN("login"),

    // PUT/DELETE
    USERS_2("users/2");

    private final String path;

    ApiPath(String path) {
        this.path = path;
    }
}
