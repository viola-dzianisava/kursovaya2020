package com.gym.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trainer {
    private int idTrainer;
    private String name;
    private String photo;
    private String style;
    private int experience;

    public Trainer() {
    }

    public Trainer(int idTrainer, String name, String photo, String style, int experience) {
        this.idTrainer = idTrainer;
        this.name = name;
        this.photo = photo;
        this.style = style;
        this.experience = experience;
    }

    public int getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
