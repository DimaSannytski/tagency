package com.ua.tagency.dao;

import com.ua.tagency.entity.UserRole;
import com.ua.tagency.entity.enums.UserRoleEnum;

public interface UserRoleDao {
    UserRole findByRole(UserRoleEnum userRoleEnum);
}
