package ru.innopolis.my.common.service;

import ru.innopolis.my.server.entity.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> getUserList();

    void addUser(User user);

    void delUser(Long id);


}
