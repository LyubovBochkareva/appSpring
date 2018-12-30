package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.model.User;
import spring.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @RequestMapping(value = "/")
    public ModelAndView getAllUsers(ModelAndView model){
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
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView insertUser(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("UserForm");
        return model;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("UserForm") User user) {
        userServiceImpl.saveOrUpdate(user);
        return new ModelAndView("redirect:/");
    }

}
