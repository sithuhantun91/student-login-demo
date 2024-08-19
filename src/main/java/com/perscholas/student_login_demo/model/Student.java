package com.perscholas.student_login_demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    String email;

    @Column(nullable = false, unique = true)
    String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade =
            CascadeType.ALL)
    @JoinTable(name = "student_roles",
            joinColumns = {@JoinColumn(name = "student_id",
                    referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id ",
                    referencedColumnName = "id"
            )})
    public List<Role> roles = new ArrayList<>();

    public Student(Long id, String name, String email, String
            password, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
