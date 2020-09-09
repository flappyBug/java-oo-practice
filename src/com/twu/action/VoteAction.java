package com.twu.action;

import com.twu.user.User;

public class VoteAction implements Action {
    public static final String name = "给热搜事件投票";
    final private User user = null;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        return false;
    }
}
