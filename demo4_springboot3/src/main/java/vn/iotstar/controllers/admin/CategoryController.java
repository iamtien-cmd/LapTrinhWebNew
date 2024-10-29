package vn.iotstar.controllers.admin;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.iotstar.entity.Category;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @RequestMapping("")
    public String all(Model model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("list", list);
        return "admin/category/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        CategoryModel category = new CategoryModel();
        category.setIsEdit(false);
        model.addAttribute("category", category);
        return "admin/category/add";
    }
    @PostMapping("/save")
    public ModelAndView save(ModelMap model,
                             @Valid @ModelAttribute("category") CategoryModel categoryModel, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("admin/category/add");
        }
        Category entity = new Category();
        BeanUtils.copyProperties(categoryModel, entity);
        categoryService.save(entity);
        String message="";
        if(categoryModel.getIsEdit() == true) {
            message="Category is Edited!!!";
        }else{
            message="Category is Saved!!!";
        }
        model.addAttribute("message", message);
        return new ModelAndView("forward:/admin/categories", model);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelMap model, @PathVariable("id") Long categoryId) {
        Optional<Category> optCategory = categoryService.findById(categoryId);
        CategoryModel cateModel = new CategoryModel();
        if (optCategory.isPresent()) {
            Category entity = optCategory.get();

            BeanUtils.copyProperties(entity, cateModel);
            cateModel.setIsEdit(true);
            model.addAttribute("category", cateModel);
            return new ModelAndView("admin/category/add", model);
        }
        model.addAttribute("message", "Category is not exist!!!");
        return new ModelAndView("forward:/admin/catehories", model);
    }
    @GetMapping("delete/{id}")
    public ModelAndView delete(ModelMap model,@PathVariable("id") Long categoryId) {
        categoryService.deleteById(categoryId);
        model.addAttribute("message", "Category is Deleted!!!");
        return new ModelAndView("forward:/admin/categories", model);
    }

}
