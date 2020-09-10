package com.twu.menu;

import com.twu.Session;
import com.twu.action.*;

public class AdminMenu extends Menu {
    private final String welcomeMessage;

    public AdminMenu(Session session) {
        super(new Action[]{
                new PrintAction(session),
                new AddTrendAction(session),
                new AddSuperTrendAction(session),
                new QuitAction(session),
        });
        welcomeMessage = String.format("您好，%s，您可以：", session.getRole().getName());
    }


    @Override
    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }
}
