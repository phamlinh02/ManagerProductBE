package com.example.managerproduct.securities;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ApplicationPermission {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String STAFF = "ROLE_STAFF";

    public static final String EMPLOYEE = "ROLE_ADMIN_PROJECT";

    public static final Set<String> ALL_AUTHORITIES = new HashSet<>(Arrays.asList(ADMIN, STAFF, EMPLOYEE));

    private ApplicationPermission() {
    }
}
