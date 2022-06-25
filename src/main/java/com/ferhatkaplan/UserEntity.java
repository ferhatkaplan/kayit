package com.ferhatkaplan;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity() {
    }
    //getter and setter
}
