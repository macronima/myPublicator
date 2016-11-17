package ru.innopolis.my.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.my.entity.Topic;

public interface TopicRepository  extends CrudRepository<Topic, Long> {
}
