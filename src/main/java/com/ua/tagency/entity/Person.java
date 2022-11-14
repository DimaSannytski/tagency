package com.ua.tagency.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person extends BaseEntity {
    private String email;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    @ManyToOne
    private UserRole userRole;
    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<RoomOrder> orders;
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<RoomOrder> managedOrders;

}
