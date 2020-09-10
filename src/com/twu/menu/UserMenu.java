package com.twu.menu;

import com.twu.Session;
import com.twu.action.*;

public class UserMenu extends Menu{

    public UserMenu(Session session) {
        super(new Action[]{
                new PrintAction(session),
                new VoteAction(session),
                new BidAction(),
                new AddTrendAction(session),
                new QuitAction(session)
        });
    }
}
