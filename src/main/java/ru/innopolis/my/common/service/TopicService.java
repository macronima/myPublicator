package ru.innopolis.my.common.service;

import ru.innopolis.my.server.entity.Topic;


import java.util.List;

public interface TopicService {
    Topic getTopic(Long id);

    List<Topic> getTopicList();

    void addTopic(Topic topic);

    void delTopic(Long id);
}
