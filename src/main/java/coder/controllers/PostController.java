package coder.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CatService catService;

    @Autowired
    private UserService userService;

    @GetMapping("/post/all")
    public String showAllPost(Model model) {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "author.post.all";
    }

    @GetMapping("/author/post/create")
    public String showPostCreatePage(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("cats", catService.getAllCat());
        return "author.post.create";
    }

    @PostMapping("/author/post/create")
    public String addPost(Post post, HttpServletRequest request) {
        MultipartFile file = post.getFile();
        if(file != null && !file.isEmpty()) {
            String imgName = saveImage(file, request);
            post.setImage(imgName);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            User user = userService.getUserByUserName(username);
            post.setUser_id(user.getId());
        }
        postService.addPost(post);
        return "redirect:/author/home";
    }

    @GetMapping("/author/post/edit/{id}")
    public String showPostEditPage(@PathVariable("id") int id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("cats", catService.getAllCat());
        return "author.post.edit";
    }

    @PostMapping("/author/post/edit")
    public String editPost(Post post, HttpServletRequest request) {
        MultipartFile file = post.getFile();
        if(file != null && !file.isEmpty()) {
            String imgName = saveImage(file, request);
            post.setImage(imgName);
        }
        postService.updatePost(post);
        return "redirect:/author/home";
    }

    @GetMapping("/author/post/delete/{id}")
    public String deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
        return "redirect:/author/home";
    }

    private String saveImage(MultipartFile file, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String imgName = System.currentTimeMillis() + ".png";
        Path path = Paths.get(rootDirectory + "/WEB-INF/assets/imgs/" + imgName);
        if(file != null && !file.isEmpty()) {
            try {
                file.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Image can't be uploaded");
            }
        }
        return imgName;
    }
}
