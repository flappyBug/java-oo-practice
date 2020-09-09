package com.twu;

import com.twu.user.Role;

public class Session {
    private static final Session instance = new Session();
    private Role role;
    private final TrendBoard trendBoard;
    private final Menu menu;

    Session() {
        trendBoard = TrendBoard.getInstance();
        menu = new LoginMenu();
    }

    public static Session getInstance() {
        return instance;
    }

    public Role getUser() {
        return role;
    }

    public void printMenu() {
        menu.printMenu();
    }
}
