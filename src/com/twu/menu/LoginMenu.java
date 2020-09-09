package com.twu.menu;

import com.twu.action.*;
import com.twu.menu.Menu;

public class LoginMenu extends Menu {
    public static final String welcomeMessage = "欢迎来到热搜排行榜，请问您是？";

    public LoginMenu() {
        super(new Action[]{
                new AdminLoginAction(),
                new UserLoginAction(),
                new QuitAction(),
        });
    }
}
