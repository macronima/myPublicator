package ru.innopolis.my.server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.my.server.entity.Topic;

public interface TopicRepository  extends CrudRepository<Topic, Long> {
}
