package com.MichalWojcik.Mems.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.MichalWojcik.Mems.model.Category;
import com.MichalWojcik.Mems.repository.CategoryDao;
import com.MichalWojcik.Mems.repository.CategoryRepository;
import com.MichalWojcik.Mems.repository.GifDao;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    public GifDao gifDao;


    @GetMapping("/categories")
    public String findAll(ModelMap map) {
        map.put("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/gif")
    public String findCategory(ModelMap map) {
        map.put("category", categoryRepository.findAll());
        return "category";
    }

    private CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/category/{name}")
    public String gif(@PathVariable String name, ModelMap modelMap) {
        Category category = categoryRepository.findByCategory(name);
        modelMap.addAttribute("category",category);
        modelMap.addAttribute("gifs", gifDao.findByCategory((long)category.getId()));
        return "category";
    }
}


