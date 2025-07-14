package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allCars(ModelMap model) {
        model.addAttribute("messages", userService.getAllUsers(5));
        return "users";
    }

    @GetMapping(params = "count")
    public String printCars(@RequestParam("count") int count, ModelMap model) {
        model.addAttribute("messages", userService.getAllUsers(count));
        return "users";
    }
}
