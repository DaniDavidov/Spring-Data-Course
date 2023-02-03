package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookReducedInfo;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int count);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lessThan, BigDecimal greaterThan);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate lowerBound, LocalDate upperBound);

    List<Book> findByTitleContaining(String str);

    List<Book> findByAuthorLastNameStartingWith(String str);

    @Query(value = "SELECT COUNT(b) FROM Book b" +
            " WHERE LENGTH(b.title) > :number")
    int countByTitleLengthMoreThan(int number);

    @Query(value = "SELECT b, SUM(b.copies) FROM Book b" +
            " JOIN b.author a" +
            " GROUP BY b.author")
    List<Book> bookCopiesByAuthor();

    @Query(value = "SELECT b.title, b.editionType, b.ageRestriction, b.price" +
            " FROM Book b" +
            " WHERE b.title = :title")
    BookReducedInfo findByTitle(String title);
}
