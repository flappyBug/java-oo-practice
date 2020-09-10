package com.twu.user;

import com.twu.Input;

import java.util.Optional;

public class AdminRepository extends RoleRepository {

    public static final AdminRepository instance = new AdminRepository();

    public static AdminRepository getInstance() {
        return instance;
    }

    @Override
    public Optional<Role> login() {
        Input input = Input.getInstance();
        System.out.println("请输入您的昵称：");
        String name = input.getString();
        System.out.println("请输入您的密码：");
        String password = input.getStringUntrimmed();
        // Use hardcoded auth for now
        if ("admin".equals(name) && "admin123".equals(password)) {
            return Optional.of(new Admin("admin"));
        }
        System.out.println("登录失败");
        return Optional.empty();
    }
}
