package com.ua.tagency.controller;

import com.ua.tagency.dao.PersonDao;
import com.ua.tagency.dto.PersonEditDto;
import com.ua.tagency.entity.Person;
import com.ua.tagency.service.OrderService;
import com.ua.tagency.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class PersonController {

    private final PersonService personService;
    private final OrderService orderService;
    private final PersonDao personDao;

    @Autowired
    public PersonController(PersonService personService, OrderService orderService, PersonDao personDao) {
        this.personService = personService;
        this.orderService = orderService;
        this.personDao = personDao;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    @GetMapping("/person/{personId}")
    public String personPage(@PathVariable Integer personId, Model model, Principal principal) {
        model.addAttribute("personModel", personService.getPersonPage(personId));
        model.addAttribute("orders", orderService.getByCreatorId(personId));
        model.addAttribute("userDet", personService.getPersonDetails(principal));
        return "person";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/persons")
    public String allPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "persons";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    @GetMapping("/person/edit/{personId}")
    public String editPerson(Model model, @PathVariable Integer personId) {
        model.addAttribute("personModel", personService.getEditDto(personId));
        return "edit_person";
    }

    @GetMapping("/my_profile")
    public String goToMyOrders(Principal principal) {
        if (personService.needToAuthorise(principal)) return "redirect:/login";
        Person person = personDao.findPersonByEmail(principal.getName());
        return "redirect:/person/" + person.getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    @PostMapping("/person/edit")
    public String updatePerson(@ModelAttribute("personModel") PersonEditDto dto) {
        personService.update(dto);
        return "redirect:/person/" + dto.getId();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/person/delete")
    public String deletePerson(@RequestParam Integer id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }
}
