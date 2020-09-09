package com.twu;

import com.twu.action.*;

public class LoginMenu extends Menu {
    LoginMenu() {
        super(new Action[]{
                new AdminLoginAction(),
                new UserLoginAction(),
                new QuitAction(),
        });
    }
}
