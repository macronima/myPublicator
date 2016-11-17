package ru.innopolis.my.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.my.server.entity.Topic;
import ru.innopolis.my.common.service.TopicService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;
 

    /**
     * Получение страницы занятий
     *
     * @return страница занятий
     */
    @RequestMapping(value = "topicPage", method = RequestMethod.GET)
    public String getTopicPage() {
        return "topics";
    }



    /**
     * Форма создания занятия
     *
     * @param map
     * @return форма
     */
    @RequestMapping(value = "topic", method = RequestMethod.GET)
    public String addTopicPage(ModelMap map) {
        map.addAttribute("type", "Режим добавления занятия");
        map.addAttribute("topic", new Topic());
        return "topic";
    }

    /**
     * Форма редактирования занятий
     *
     * @param id  - занятия
     * @param map
     * @return форма
     */
    @RequestMapping(value = "topic/{id}", method = RequestMethod.GET)
    public String editTopicForm(@PathVariable("id") Long id, ModelMap map, HttpServletResponse response) {
        map.addAttribute("type", "Режим редактирования занятия");

            map.addAttribute("topic", topicService.getTopic(id));
            return "topic";


    }

    /**
     * Форма добавления студентов к занятиям
     *
     * @param idTopic - занятия
     * @param map
     * @return форма
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "putStudent/{id}", method = RequestMethod.GET)
    public String putStudentForm(@PathVariable("id") Long idTopic, ModelMap map, HttpServletResponse response) {
        map.addAttribute("type", "Режим добавления студентов к занятиям");
            map.addAttribute("topic", topicService.getTopic(idTopic));
            //получение студентов не посетивших текущее занятие
            //map.addAttribute("studentList", studentService.getStudentListIsNotTopic(idTopic));



        return "putStudent";
    }


    /**
     * Сохранение занятия
     *
     * @param topic Занятие
     * @param map
     * @return страницца success(msg)
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "saveTopic", method = RequestMethod.POST)
    public String saveTopic(Topic topic, ModelMap map, HttpServletResponse response) {
            topicService.addTopic(topic);
            map.put("message", "Занятие сохранено!");
            return "success";
    }

    /**
     * Удаление занятия
     *
     * @param id  занятия
     * @param map
     * @return страницца success(msg)
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "delTopic/{id}", method = RequestMethod.POST)
    public String delTopic(@PathVariable("id") Long id, ModelMap map, HttpServletResponse response) {
            topicService.delTopic(id);
            map.put("message", "Занятие удалено!");
            return "success";

    }
}
