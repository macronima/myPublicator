package ru.innopolis.my.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.my.server.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String s);
    /*
save
findOne
exists
findAll
count
delete
deleteAll
 */
}
