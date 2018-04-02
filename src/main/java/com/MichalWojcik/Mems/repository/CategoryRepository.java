package com.MichalWojcik.Mems.repository;


import com.MichalWojcik.Mems.model.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll();

    Category findByName(String name);

//    Category findById(Long id);
    public Category findByCategory(String name);
}
