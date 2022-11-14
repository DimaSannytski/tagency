package com.ua.tagency.service.impl;

import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.dao.UserRoleDao;
import com.ua.tagency.dto.PersonDetailsDto;
import com.ua.tagency.dto.PersonEditDto;
import com.ua.tagency.dto.PersonPageDto;
import com.ua.tagency.dto.RegisterDto;
import com.ua.tagency.entity.Person;
import com.ua.tagency.entity.enums.UserRoleEnum;
import com.ua.tagency.mapper.PersonMapper;
import com.ua.tagency.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonMapper personMapper;
    private final PersonDao personDao;
    private final UserRoleDao userRoleDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonServiceImpl(PersonMapper personMapper, PersonDao personDao, UserRoleDao userRoleDao,
                             PasswordEncoder passwordEncoder) {
        this.personMapper = personMapper;
        this.personDao = personDao;
        this.userRoleDao = userRoleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(RegisterDto registerDto) {
        Person person = personMapper.registerDtoToPerson(registerDto);
        person.setUserRole(userRoleDao.findByRole(UserRoleEnum.ROLE_USER));
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personDao.save(person);
    }

    @Override
    public void deleteById(Integer id) {
        personDao.deleteById(id);
    }

    @Override
    public void update(PersonEditDto dto) {
        Person person = personDao.findById(dto.getId());
        if (person == null) return;
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());
        personDao.update(person);
    }

    @Override
    public PersonPageDto getPersonPage(Integer id) {
        Person person = personDao.findById(id);
        return personMapper.map(person);
    }

    @Override
    public List<PersonPageDto> getAllPersons() {
        return personDao.findAll().stream().map(personMapper::map).collect(Collectors.toList());
    }

    @Override
    public PersonEditDto getEditDto(Integer id) {
        return personMapper.mapEdit(personDao.findById(id));
    }

    @Override
    public boolean needToAuthorise(Principal principal) {
        if (principal == null) return true;
        Person person = personDao.findPersonByEmail(principal.getName());
        return person == null;
    }

    @Override
    public PersonDetailsDto getPersonDetails(Principal principal) {
        PersonDetailsDto personDetails = new PersonDetailsDto();
        if (principal == null) return personDetails;
        Person person = personDao.findPersonByEmail(principal.getName());
        if (person == null) return personDetails;
        personDetails.setUser(person.getUserRole().getRole() == UserRoleEnum.ROLE_USER);
        personDetails.setAdmin(person.getUserRole().getRole() == UserRoleEnum.ROLE_ADMIN);
        return personDetails;

    }

    @Override
    public Integer getPersonIdFromPrincipal(Principal principal) {
        if (principal == null) return null;
        Person person = personDao.findPersonByEmail(principal.getName());
        if (person == null) return null;
        return person.getId();
    }
}
