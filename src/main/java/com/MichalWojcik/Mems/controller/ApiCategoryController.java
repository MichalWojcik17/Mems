package com.MichalWojcik.Mems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.MichalWojcik.Mems.repository.CategoryRepository;

@RequestMapping("/api")
@ResponseBody
public class ApiCategoryController {

    @Autowired
    CategoryRepository categoryRepository;

//    @GetMapping("/categories/{id}")
//    public Category getCategories(@PathVariable int id){
//        Category category= categoryRepository.findById(id);
//    }
}
