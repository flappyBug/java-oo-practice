package com.twu.menu;

import com.twu.action.*;

public class UserMenu extends Menu{

    public UserMenu() {
        super(new Action[]{
                new PrintAction(),
                new VoteAction(),
                new BidAction(),
                new AddTrendAction(),
                new QuitAction()
        });
    }
}
