package com.twu.user;

import com.twu.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends RoleRepository {

    private static final UserRepository instance = new UserRepository();
    private final Map<String, User> users = new HashMap<>();

    public static UserRepository getInstance() {
        return instance;
    }

    @Override
    public Optional<Role> login() {
        System.out.print("请输入您的昵称：");
        Input input = Input.getInstance();
        String name = input.getString();
        if (users.containsKey(name)) {
            return Optional.of(users.get(name));
        }
        User user = new User(name);
        users.put(name, user);
        return Optional.of(user);
    }
}
