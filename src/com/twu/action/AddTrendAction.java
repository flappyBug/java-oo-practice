package com.twu.action;

public class AddTrendAction implements Action{
    private static final String name = "添加热搜";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
