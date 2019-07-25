package coder.controllers;

import coder.models.Category;
import coder.models.Post;
import coder.models.User;
import coder.services.CatService;
import coder.services.PostService;
import coder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {
    @Autowired
    private CatService catService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAllPost();
        List<Category> cats = catService.getAllCat();
        model.addAttribute("posts", posts);
        model.addAttribute("cats", cats);
        return "home";
    }

    @GetMapping("/post/postdetail/{id}")
    public String postDetail(@PathVariable("id") int id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "postdetail";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/author/home")
    public String author(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User user = userService.getUserByUserName(username);
            List<Post> posts = user.getPosts();
            List<Category> cats = catService.getAllCat();
            model.addAttribute("posts", posts);
            model.addAttribute("cats", cats);
        }
        boolean bol = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(bol) {
            return "admin.home";
        }
        return "author.home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error,
                        @RequestParam(name = "logout", required = false) String logout,
                        Model model) {
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        if(error != null) {
            model.addAttribute("error", "Login error, please try again!");
        }
        if(logout != null) {
            model.addAttribute("logout", "You are successfully logout!");
        }
        return "login";
    }
}
