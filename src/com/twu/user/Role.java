package com.twu.user;

import com.twu.action.Action;

import java.util.List;

public abstract class Role {
    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
