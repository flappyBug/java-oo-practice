package com.twu.menu;

import com.twu.Session;
import com.twu.action.*;

public class UserMenu extends Menu{

    private final String welcomeMessage;
    public UserMenu(Session session) {
        super(new Action[]{
                new PrintAction(session),
                new VoteAction(session),
                new BidAction(session),
                new AddTrendAction(session),
                new QuitAction(session)
        });
        welcomeMessage = String.format("您好，%s，您可以：", session.getRole().getName());
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }
}
