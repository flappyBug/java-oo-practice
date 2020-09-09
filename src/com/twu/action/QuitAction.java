package com.twu.action;

public class QuitAction implements Action {

    private static final String name = "退出";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
