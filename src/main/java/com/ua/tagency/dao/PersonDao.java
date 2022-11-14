package com.ua.tagency.dao;

import com.ua.tagency.entity.Person;

public interface PersonDao extends BaseDao<Person, Integer> {
    Person findPersonByEmail(String login);
}
