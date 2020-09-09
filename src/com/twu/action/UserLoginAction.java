package com.twu.action;

import com.twu.Session;
import com.twu.user.UserRepository;
import com.twu.menu.UserMenu;
import com.twu.user.User;

public class UserLoginAction implements Action {
    private static final String name = "用户";
    private static final UserRepository userRepository = UserRepository.getInstance();
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        //UserRepository::login will always return a User
        //noinspection OptionalGetWithoutIsPresent
        User user = (User) userRepository.login().get();
        Session session = Session.getInstance();
        session.setRole(user);
        session.pushMenu(new UserMenu());
        return true;
    }
}
