package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Author;
import com.example.spring_data_intro.entities.Book;
import com.example.spring_data_intro.entities.Category;
import com.example.spring_data_intro.enums.AgeRestriction;
import com.example.spring_data_intro.enums.EditionType;
import com.example.spring_data_intro.repositories.AuthorRepository;
import com.example.spring_data_intro.repositories.BookRepository;
import com.example.spring_data_intro.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private static final String RESOURCE_PATH = "src/main/resources/files";
    private static final String AUTHORS_FILE_PATH = RESOURCE_PATH + "/authors.txt";
    private static final String CATEGORIES_FILE_PATH = RESOURCE_PATH + "/categories.txt";
    private static final String BOOKS_FILE_PATH = RESOURCE_PATH + "/books.txt";

    private AuthorRepository authorRepository;
    private AuthorService authorService;
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private BookRepository bookRepository;

    @Autowired
    public SeedServiceImpl(AuthorRepository authorRepository, CategoryRepository categoryRepository, AuthorService authorService, CategoryService categoryService, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Path path = Path.of(AUTHORS_FILE_PATH).toAbsolutePath();
        Files.readAllLines(Path.of(String.valueOf(path)))
                .stream()
                .filter(s -> !s.isBlank())
                .map(s -> s.split(" "))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Path path = Path.of(CATEGORIES_FILE_PATH).toAbsolutePath();
        Files.readAllLines(Path.of(String.valueOf(path)))
                .stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    Author author = authorService.getRandomAuthor();
                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
                    LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction .values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));
                    Set<Category> categories = categoryService.getRandomCategories();


                    Book book = new Book(title, editionType, price, copies, releaseDate, ageRestriction, author, categories);
                    bookRepository.save(book);
                });
    }
}
