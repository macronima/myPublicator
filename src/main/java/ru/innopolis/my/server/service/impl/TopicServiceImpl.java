package ru.innopolis.my.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.my.server.entity.Topic;
import ru.innopolis.my.server.repository.TopicRepository;
import ru.innopolis.my.common.service.TopicService;

import java.util.List;
@Service("TopicService")
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicRepository tR;

    @Override
    public Topic getTopic(Long id) {return tR.findOne(id);}

    @Override
    public List<Topic> getTopicList() {return (List)tR.findAll();}

    @Override
    public void addTopic(Topic topic){tR.save(topic);}

    @Override
    public void delTopic(Long id){tR.delete(id);}
}
