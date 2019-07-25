package coder.controllers;

import coder.models.Category;
import coder.models.Post;
import coder.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CatService catService;

    @GetMapping("/admin/cat/all")
    public String showAllCat(Model model) {
        List<Category> cats = catService.getAllCat();
        model.addAttribute("cats", cats);
        return "admin.cat.all";
    }

    @GetMapping("/cat/post/{id}")
    public String catpost(@PathVariable("id") int id, Model model) {
        Category cat = catService.getCatById(id);
        List<Post> posts = cat.getPosts();
        List<Category> cats = catService.getAllCat();
        model.addAttribute("posts", posts);
        model.addAttribute("cats", cats);
        return "cat.post";
    }

    @GetMapping("/admin/cat/edit/{id}")
    public String showEditCatPage(@PathVariable("id") int id, Model model) {
        Category category = catService.getCatById(id);
        model.addAttribute("category", category);
        return "admin.cat.edit";
    }

    @PostMapping("/admin/cat/edit")
    public String editCat(Category category) {
        catService.updateCat(category);
        return "redirect:/admin/cat/all";
    }

    @GetMapping("/admin/cat/delete/{id}")
    public String deleteCat(@PathVariable("id") int id) {
        catService.deleteCat(id);
        return "redirect:/admin/cat/all";
    }

    @GetMapping("/admin/cat/create")
    public String showCatCreatePage(Model model) {
        model.addAttribute("category", new Category());
        return "admin.cat.create";
    }

    @PostMapping("/admin/cat/create")
    public String createCategory(Category category) {
        catService.addCat(category);
        return "redirect:/admin/cat/all";
    }

}
