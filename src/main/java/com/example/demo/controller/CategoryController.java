package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")

public class CategoryController {
    @Autowired
    private ICategoryService service;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = service.finAll();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @GetMapping("/new")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/new";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute("category") Category category) {
        service.insert(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        Category category = service.findById(id);
        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/{id}")
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category) {
        service.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/categories";
    }

    @GetMapping("/search")
    public String searchCategories(@RequestParam("keyword") String keyword, Model model) {
        List<Category> categories = service.finName(keyword);
        model.addAttribute("categories", categories);
        return "categories/list";
    }
}
