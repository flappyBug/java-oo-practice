package com.twu.action;

import com.twu.Session;

public class QuitAction implements Action {

    private static final String name = "退出";
    private final Session session;

    public QuitAction(Session session) {
        this.session = session;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        session.popMenu();
        return true;
    }
}
