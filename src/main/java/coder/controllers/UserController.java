package coder.controllers;

import coder.models.Authority;
import coder.models.Category;
import coder.models.User;
import coder.services.CatService;
import coder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private CatService catService;

    @GetMapping("/admin/user/all")
    public String showAllUser(Model model) {
        List<User> users = userService.getAllUser();
        List<Category> cats = catService.getAllCat();
        model.addAttribute("users", users);
        model.addAttribute("cats", cats);
        return "admin.user.all";
    }

    @GetMapping("/admin/user/toggle/{id}")
    public String activeOrBanUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if(user.isEnabled()) {
            user.setEnabled(false);
        } else {
            user.setEnabled(true);
        }
        userService.updateUser(user);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "register";
        }
        userService.createUser(user);
        userService.addAuth(new Authority(user.getUsername(), "ROLE_USER"));
        model.addAttribute("register", "Successfully registered, please login!");
        return "login";
    }

}
