package com.twu.menu;

import com.twu.Session;
import com.twu.action.Action;
import com.twu.action.AdminLoginAction;
import com.twu.action.QuitAction;
import com.twu.action.UserLoginAction;

public class LoginMenu extends Menu {
    public static final String welcomeMessage = "欢迎来到热搜排行榜，请问您是？";

    @Override
    public void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }

    public LoginMenu(Session session) {
        super(new Action[]{
                new AdminLoginAction(session),
                new UserLoginAction(session),
                new QuitAction(session),
        });
    }
}
