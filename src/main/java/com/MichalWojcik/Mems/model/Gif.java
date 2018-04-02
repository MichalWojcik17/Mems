package com.MichalWojcik.Mems.model;

public class Gif {
    private Long id;
    private String name;

    private String userName;

    private Long idCategory;

    private boolean isFavourite;

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public Gif(String userName) {
        this.userName = userName;
    }


    public String getGifPath() {
        return "/gifs/" + name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
         public Gif(Long id, String name, String userName) {
            this(id,name);
            this.userName = userName;
    }

    public Gif(Long id, String name) {

        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return getGifPath();
    }

    public String getUserName() {
        return userName;
    }

    public Gif(Long id, String name, Long idCategory, boolean isFavourite){
        this(id,name);
        this.idCategory = idCategory;
        this.isFavourite = isFavourite;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}
