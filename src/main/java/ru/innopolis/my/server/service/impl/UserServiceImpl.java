package ru.innopolis.my.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.my.server.entity.User;
import ru.innopolis.my.server.repository.UserRepository;
import ru.innopolis.my.common.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository uR;

    @Override
    public User getUser(Long id) {return uR.findOne(id);}

    @Override
    public List<User> getUserList() {return (List)uR.findAll();}

    @Override
    public void addUser(User user){uR.save(user);}

    @Override
    public void delUser(Long id){uR.delete(id);}
}
