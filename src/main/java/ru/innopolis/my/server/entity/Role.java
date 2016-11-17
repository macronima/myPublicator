package ru.innopolis.my.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@SuppressWarnings("PMD")
@Entity
@Table(name = "roles")

public class Role extends AbstractIdentifiableObject{
    //Роль
    @Column(name = "name", unique = true)
    private String name;
}