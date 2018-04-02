package com.MichalWojcik.Mems.repository;

import com.MichalWojcik.Mems.model.Gif;

import java.util.List;

public interface GifDao {

 List<Gif> findAll();

 String findUserNameByGifName(String memName);

 Gif findByName(String name);
 List<Gif> find(String memName);
 List<Gif> findByCategory(Long id);
 List<Gif> findByCategoryName(String name);
}

