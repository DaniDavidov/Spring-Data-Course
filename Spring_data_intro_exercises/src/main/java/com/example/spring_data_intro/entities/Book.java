package com.example.spring_data_intro.entities;

import com.example.spring_data_intro.enums.AgeRestriction;
import com.example.spring_data_intro.enums.EditionType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(length = 1000)
    private String description;
    @Column(name = "edition_type", nullable = false)
    private EditionType editiontype;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int copies;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "age_restriction", nullable = false)
    private AgeRestriction ageRestriction;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany
    private Set<Category> categories;

    public Book() {
        this.categories = new LinkedHashSet<>();
    }

    public Book(String title, String description, EditionType editiontype, BigDecimal price, int copies, LocalDate releaseDate, AgeRestriction ageRestriction, Author author) {
        this();
        this.title = title;
        this.description = description;
        this.editiontype = editiontype;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
    }

    public Book(String title, EditionType editionType, BigDecimal price, int copies, LocalDate releaseDate, AgeRestriction ageRestriction, Author author, Set<Category> categories) {
        this.title = title;
        this.editiontype = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.author = author;
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return Collections.unmodifiableSet(categories);
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EditionType getEditiontype() {
        return editiontype;
    }

    public void setEditiontype(EditionType editiontype) {
        this.editiontype = editiontype;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
