package com.twu.action;

import com.twu.Session;

public class PrintAction implements Action {
    private static final String name = "查看热搜排行榜";

    private final Session session;
    public PrintAction(Session session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        System.out.print(session.getTrendBoard().display());
        return true;
    }
}
