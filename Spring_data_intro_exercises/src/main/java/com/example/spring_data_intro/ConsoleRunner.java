package com.example.spring_data_intro;

import com.example.spring_data_intro.entities.Author;
import com.example.spring_data_intro.entities.Book;
import com.example.spring_data_intro.repositories.AuthorRepository;
import com.example.spring_data_intro.repositories.BookRepository;
import com.example.spring_data_intro.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private SeedService seedService;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private void _01_booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 12, 31);
        List<Book> byReleaseDateAfter = bookRepository.findByReleaseDateAfter(year2000);

        for (Book book : byReleaseDateAfter) {
            System.out.println(book.getTitle());
        }
    }

    private void _02_allAuthorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Book> byReleaseDateAfter = bookRepository.findByReleaseDateBefore(year1990);
        Set<Author> authors = new LinkedHashSet<>();

        for (Book book : byReleaseDateAfter) {
            authors.add(book.getAuthor());
        }

        for (Author author : authors) {
            System.out.printf("%s %s%n", author.getFirstName(), author.getLastName());
        }
    }

    private void _03_allAuthorsSortedByBooks() {
        List<Author> authors = authorRepository.findAll();
        authors.stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(author -> System.out.printf("%s %s -> %d%n",
                        author.getFirstName(), author.getLastName(), author.getBooks().size()));

    }

    @Override
    public void run(String... args) throws IOException {
//        this.seedService.seedAuthors();
//        this.seedService.seedCategories();
//        this.seedService.seedBooks();
//        _01_booksAfter2000();
//        _02_allAuthorsWithBookBefore1990();
        _03_allAuthorsSortedByBooks();
    }



}
