package com.gym.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "style", schema = "gym")
public class StyleEntity {
    private int idStyle;
    private String style;

    @Id
    @Column(name = "id_style")
    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
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

        StyleEntity that = (StyleEntity) o;

        if (idStyle != that.idStyle) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStyle;
        result = 31 * result + (style != null ? style.hashCode() : 0);
        return result;
    }
}
