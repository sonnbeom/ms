package com.hypeboy.hypeBoard.enums;

public enum UserRole {
    ROLE_USER("U"),
    ROLE_ADMIN("A");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}

