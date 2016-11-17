package ru.innopolis.my.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("PMD")
@Entity
@Table(name = "users")
@Data
public class User extends AbstractIdentifiableObject{

    //Логин
    @Column(name = "login", unique = true)
    private String login;

    //Пароль
    @Column(name = "password")
    private String password;

    //Имя
    @Column(name = "name")
    private String name;

    //Фамилия
    @Column(name = "surname")
    private String surname;


    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinTable(name = "role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    //Актиность пользователя
    @Column(name = "active")
    private boolean active;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}