package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookReducedInfo;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesCount(EditionType editionType, int copies);

    List<Book> findByPriceLessAndGreaterThan(BigDecimal lessThan, BigDecimal greaterThan);

    List<Book> findByReleaseDateNotIn(LocalDate lowerBound, LocalDate uppedBound);

    List<Book> findByStringContainedInTitle(String str);

    List<Book> findByAuthorNameStartingWith(String str);

    int countByTitleLengthLongerThan(int number);

    List<Book> sumBookCopiesByAuthor();

    BookReducedInfo findByTitle(String title);
}
