package ru.innopolis.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.my.entity.User;
import ru.innopolis.my.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    
    /**
     * Получение страницы пользователей
     *
     * @return
     */
    @RequestMapping(value = "userPage", method = RequestMethod.GET)
    public String getUserPage() {
        return "users";
    }

    

    /**
     * Форма создания пользователя
     *
     * @param map
     * @return форма
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String addUserPage(ModelMap map) {
        map.addAttribute("type", "Режим добавления пользователя");
        map.addAttribute("user", new User());
        return "user";

    }

    /**
     * Форма редактирования пользователя
     *
     * @param id  - пользователя
     * @param map
     * @return форма
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable("id") Long id, ModelMap map, HttpServletResponse response) {
        map.addAttribute("type", "Режим редактирования пользователя");
            map.addAttribute("user", userService.getUser(id));
          //  map.addAttribute("sumLesson", userService.countLesson(id));
            return "user";
       


    }

    /**
     * Сохранение пользователя
     *
     * @param user Пользователь
     * @param map
     * @return msg
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(User user, ModelMap map, HttpServletResponse response) {
        
            userService.addUser(user);
            map.put("message", "Пользователь сохранен!");
            return "success";
      

    }

    /**
     * Удаление пользователя
     *
     * @param id  пользователя
     * @param map
     * @return msg
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "deleteStd/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long id, ModelMap map, HttpServletResponse response) {
            userService.delUser(id);
            map.put("message", "Пользователь удален!");
            return "success";
      
    }
    
}
