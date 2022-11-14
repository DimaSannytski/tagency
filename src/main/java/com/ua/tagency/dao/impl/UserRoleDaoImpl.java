package com.ua.tagency.dao.impl;

import com.ua.tagency.dao.UserRoleDao;
import com.ua.tagency.entity.Person;
import com.ua.tagency.entity.UserRole;
import com.ua.tagency.entity.enums.UserRoleEnum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserRoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserRole findByRole(UserRoleEnum userRoleEnum) {
        List<UserRole> userRoles = sessionFactory.getCurrentSession().createQuery("from UserRole where role=?1")
                .setParameter(1, userRoleEnum)
                .list();
        if (userRoles.isEmpty()) return null;
        return userRoles.get(0);
    }
}
