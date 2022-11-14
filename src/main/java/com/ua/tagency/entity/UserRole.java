package com.ua.tagency.entity;

import com.ua.tagency.entity.enums.UserRoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
    @OneToMany(mappedBy="userRole",cascade = CascadeType.ALL)
    List<Person> personList;
}
