package com.twu.user;

import com.twu.user.Role;

import java.util.Optional;

public abstract class RoleRepository {
    abstract Optional<Role> login();
}
