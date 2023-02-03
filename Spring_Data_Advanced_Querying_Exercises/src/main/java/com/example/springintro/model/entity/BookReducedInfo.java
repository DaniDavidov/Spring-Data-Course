package com.example.springintro.model.entity;

import java.math.BigDecimal;

public class BookReducedInfo {
    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;
    private BigDecimal price;

    public BookReducedInfo(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    public BookReducedInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookReducedInfo{" +
                "title='" + title + '\'' +
                ", editionType=" + editionType +
                ", ageRestriction=" + ageRestriction +
                ", price=" + price +
                '}';
    }
}
