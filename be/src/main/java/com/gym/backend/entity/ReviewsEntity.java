package com.gym.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "reviews", schema = "gym")
public class ReviewsEntity {
    private int idReviews;
    private String name;
    private String review;

    @Id
    @Column(name = "id_reviews")
    public int getIdReviews() {
        return idReviews;
    }

    public void setIdReviews(int idReviews) {
        this.idReviews = idReviews;
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
    @Column(name = "review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewsEntity that = (ReviewsEntity) o;

        if (idReviews != that.idReviews) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (review != null ? !review.equals(that.review) : that.review != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReviews;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (review != null ? review.hashCode() : 0);
        return result;
    }
}
