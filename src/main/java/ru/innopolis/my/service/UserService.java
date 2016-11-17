package ru.innopolis.my.service;

import ru.innopolis.my.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getUserList();

    void addUser(User user);

    void delUser(Long id);


}
