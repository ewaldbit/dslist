package com.superior.dslist.dtos;

import com.superior.dslist.entities.Game;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String ImgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        ImgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
