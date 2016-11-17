package ru.innopolis.my.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("PMD")
@MappedSuperclass
abstract class AbstractIdentifiableObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Version
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "version")
    @Getter
    @Setter
    private Long version;



}
