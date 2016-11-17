package ru.innopolis.my.common.modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
public class TopicModal extends AbstractIdentifiableObjectModal implements Serializable{

    private String name;
    private Date date;
    private String text;

}