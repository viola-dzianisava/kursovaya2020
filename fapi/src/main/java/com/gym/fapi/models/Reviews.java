package com.gym.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviews {

    private int idReviews;
    private String name;
    private String review;

    public Reviews() {
    }

    public Reviews(int idReviews, String name, String review) {
        this.idReviews = idReviews;
        this.name = name;
        this.review = review;
    }

    public int getIdReviews() {
        return idReviews;
    }

    public void setIdReviews(int idReviews) {
        this.idReviews = idReviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
