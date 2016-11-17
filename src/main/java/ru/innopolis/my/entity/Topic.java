package ru.innopolis.my.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("PMD")
@Entity
@Table(name = "topics")
@Data
public class Topic extends AbstractIdentifiableObject {



    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @Column(name = "text")
    private String text;

}