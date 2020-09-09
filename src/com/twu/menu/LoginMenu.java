package com.twu.menu;

import com.twu.Session;
import com.twu.action.*;

public class LoginMenu extends Menu {
    public static final String welcomeMessage = "欢迎来到热搜排行榜，请问您是？";

    public LoginMenu(Session session) {
        super(new Action[]{
                new AdminLoginAction(),
                new UserLoginAction(session),
                new QuitAction(),
        });
    }
}
