package com.twu.action;

public class UserLoginAction implements Action {
    private static final String name = "用户";

    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
