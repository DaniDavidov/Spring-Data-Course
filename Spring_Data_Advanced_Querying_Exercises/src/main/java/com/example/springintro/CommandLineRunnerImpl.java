package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookReducedInfo;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        _11_reducedBook(scanner.nextLine());

    }

    public void _01_booksTitlesByAgeRestriction(String input) {
        bookService.findByAgeRestriction(AgeRestriction.valueOf(input.toUpperCase(Locale.ROOT))).forEach(book -> System.out.println(book.getTitle()));
    }

    public void _02_goldenBooks() {
        bookService.findByEditionTypeAndCopiesCount(EditionType.GOLD, 5000).forEach(book -> System.out.println(book.getTitle()));
    }

    public void _03_booksByPrice() {
        bookService.findByPriceLessAndGreaterThan(new BigDecimal(5), new BigDecimal(40)).forEach(book -> System.out.printf("%s - %.2f%n", book.getTitle(), book.getPrice()));
    }

    public void _04_notReleasedBooks(int year) {
        bookService.findByReleaseDateNotIn(LocalDate.of(year, 1, 1), LocalDate.of(year, 12, 31))
                .forEach(book -> System.out.println(book.getTitle()));
    }

    public void _06_authorsSearch(String ending) {
        authorService.findByNameEndingWith(ending).forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    public void _07_booksSearch(String str) {
        bookService.findByStringContainedInTitle(str).forEach(book -> System.out.println(book.getTitle()));
    }

    public void _08_booksTitleSearch(String str) {
        bookService.findByAuthorNameStartingWith(str).forEach(book -> System.out.println(book.getTitle()));
    }

    public void _09_countBooks(int number) {
        int count = bookService.countByTitleLengthLongerThan(number);
        System.out.println(count);
    }

    public void _10_totalBookCopies() {
        bookService.sumBookCopiesByAuthor().forEach(book -> System.out.printf("%s %s - %d%n", book.getAuthor().getFirstName(), book.getAuthor().getLastName(), book.getCopies()));
    }

    public void _11_reducedBook(String title) {
        BookReducedInfo book = bookService.findByTitle(title);
        System.out.println(book);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

}
