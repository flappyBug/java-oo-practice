package com.twu.action;

import com.twu.Session;
import com.twu.menu.AdminMenu;
import com.twu.user.Admin;
import com.twu.user.AdminRepository;
import com.twu.user.Role;

import java.util.Optional;

public class AdminLoginAction implements Action {
    private static final String name = "管理员";
    private static final AdminRepository adminRepository = AdminRepository.getInstance();
    private final Session session;

    public AdminLoginAction(Session session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        Optional<Role> optionalRole = adminRepository.login();
        if (optionalRole.isEmpty()) {
            return false;
        }
        Admin admin = (Admin) optionalRole.get();
        session.setRole(admin);
        session.pushMenu(new AdminMenu(session));
        return true;
    }
}
