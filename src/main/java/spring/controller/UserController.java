package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.model.User;
import spring.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/users")
    public ModelAndView getAllUsers(ModelAndView model) throws IOException {
        List<User> userList = userServiceImpl.getAllUser();
        model.addObject("listUsers", userList);
        model.setViewName("users");
        return model;
    }


    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView update(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("id"));
        User user = userServiceImpl.getUserById(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("id"));
        userServiceImpl.deleteUser(userId);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView insertUser(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("UserForm");
        return model;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        if (user.getId() == 0) { // if  id is 0 then creating the
            // user other updating the user
            userServiceImpl.addUser(user);
        } else {
            userServiceImpl.updateUser(user);
        }
        return new ModelAndView("redirect:/users");
    }

}
