package com.jamesvrooney.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean role;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
