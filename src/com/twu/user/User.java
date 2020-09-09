package com.twu.user;

public class User extends Role {

    private int remainingVotes = 10;

    public User(String name) {
        super(name);
    }

}
