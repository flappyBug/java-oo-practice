package com.twu.user;

import java.util.Optional;

public abstract class RoleRepository {
    public abstract Optional<Role> login();
}
