package com.superior.dslist.dtos;

import com.superior.dslist.entities.Game;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgURL;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgURL = entity.getImgURL();
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

    public String getImgURL() {
        return imgURL;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
