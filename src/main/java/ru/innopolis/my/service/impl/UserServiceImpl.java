package ru.innopolis.my.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.my.entity.User;
import ru.innopolis.my.repository.UserRepository;
import ru.innopolis.my.repository.UserRepository;
import ru.innopolis.my.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository uR;

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {return uR.findOne(id);}

    @Override
    public List<User> getUserList() {return (List)uR.findAll();}

    @Override
    public void addUser(User user){uR.save(user);}

    @Override
    public void delUser(Long id){uR.delete(id);}
}
