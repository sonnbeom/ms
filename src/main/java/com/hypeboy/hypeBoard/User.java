package com.hypeboy.hypeBoard;

import lombok.Data;

@Data
public class User {
    String id;
    String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
