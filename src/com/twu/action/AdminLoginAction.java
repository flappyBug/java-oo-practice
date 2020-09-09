package com.twu.action;

public class AdminLoginAction implements Action {
    private static final String name = "管理员";

    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
