package com.MichalWojcik.Mems.repository;

import org.springframework.stereotype.Component;
import com.MichalWojcik.Mems.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDao implements CategoryRepository {

    private static List<Category> categories = new ArrayList<>();


    static {
        categories.add(new Category(1,"Android"));
        categories.add(new Category(2,"Funny"));
        categories.add(new Category(3, "Programming"));
    }


    public CategoryDao(){}


    @Override
    public List<Category> findAll(){
        return categories;
    }

    @Override
    public Category findByName(String name) {
        return null;
    }


    public Category findByCategory(String name) {
        return categories.stream().filter(c->c.getName().equals( name)).collect(Collectors.toList()).get(0);
    }

}
