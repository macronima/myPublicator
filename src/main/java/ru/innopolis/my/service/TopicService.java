package ru.innopolis.my.service;

import ru.innopolis.my.entity.Topic;


import java.util.List;

public interface TopicService {
    Topic getTopic(Long id);

    List<Topic> getTopicList();

    void addTopic(Topic topic);

    void delTopic(Long id);
}
