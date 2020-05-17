package com.gym.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "trainer", schema = "gym")
public class TrainerEntity {
    private int idTrainer;
    private String name;
    private String photo;
    private String style;
    private int experience;

    @Id
    @Column(name = "id_trainer")
    public int getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "experience")
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainerEntity that = (TrainerEntity) o;

        if (idTrainer != that.idTrainer) return false;
        if (experience != that.experience) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrainer;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + experience;
        return result;
    }
}
