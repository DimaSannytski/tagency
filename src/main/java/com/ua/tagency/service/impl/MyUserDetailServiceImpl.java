package com.ua.tagency.service.impl;

import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Qualifier("userDetService")
@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    private final PersonDao personDao;

    @Autowired
    public MyUserDetailServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person person = personDao.findPersonByEmail(login);
        List<GrantedAuthority> grantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority(person.getUserRole().getRole().toString()));

        return new User(person.getEmail(), person.getPassword(), person.getIsEnabled(),
                true, true, true, grantedAuthorities);
    }
}
