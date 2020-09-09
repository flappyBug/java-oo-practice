package com.twu.menu;

import com.twu.Session;
import com.twu.action.*;

public class UserMenu extends Menu{

    public UserMenu(Session session) {
        super(new Action[]{
                new PrintAction(),
                new VoteAction(),
                new BidAction(),
                new AddTrendAction(),
                new QuitAction(session)
        });
    }
}
