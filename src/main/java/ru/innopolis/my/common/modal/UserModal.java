package ru.innopolis.my.common.modal;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class UserModal extends AbstractIdentifiableObjectModal implements Serializable {

    private String login;
    private String password;
    private String name;
    private String surname;
    private List<RoleModal> roles;
    private boolean active;

}