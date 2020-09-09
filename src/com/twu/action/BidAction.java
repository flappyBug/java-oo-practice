package com.twu.action;

public class BidAction implements Action {
    public static final String name = "购买热搜";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
