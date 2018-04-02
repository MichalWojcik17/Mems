package com.MichalWojcik.Mems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.MichalWojcik.Mems.model.Category;
import com.MichalWojcik.Mems.model.Gif;
import com.MichalWojcik.Mems.repository.CategoryDao;
import com.MichalWojcik.Mems.repository.GifDao;

import java.util.ArrayList;
import java.util.List;


    @Controller
    public class HomeController {

        @Autowired
        public GifDao gifDao;
        @Autowired
        public CategoryDao categoryDao;

        @GetMapping("/")
        public String home(ModelMap modelMap) {
            modelMap.put("gifs", gifDao.findAll());
            return "home";
        }


        @GetMapping("/gif/{name}")
        public String gif(@PathVariable String name, ModelMap modelMap){
            modelMap.addAttribute("gif",gifDao.findByName(name));
            return "gif-details";
        }
//    @GetMapping("/gif")
//    public String hrrome(){
//        return "gif";
//    }


        @GetMapping("/favorites")
        public String favorites(ModelMap modelMap) {
            List<Gif> favorites = new ArrayList<>();
            for (Gif gifs : gifDao.findAll()) {
                if (gifs.isFavourite()) {
                    favorites.add(gifs);
                }
            }
            modelMap.put("gifs", favorites);
            return "favorites";
        }

        @GetMapping("/home/search")
        public String search(@RequestParam String name, ModelMap modelMap) {

            if (isCategory(name)) {
                return "redirect:/category/"+ categoryDao.findByCategory(name).getName();
            } else
            if (gifDao.find(name).size() == 0)
                modelMap.addAttribute("message", "Nie ma takiego gifa");
            else
                modelMap.addAttribute("gifs", gifDao.find(name));
            return "home";

        }
        public boolean isCategory(String searchRequest){
            for(Category category : categoryDao.findAll()) {
                if (searchRequest.equals(category.getName())) {
                    return true;
                }
            }
            return false;
        }
    }




