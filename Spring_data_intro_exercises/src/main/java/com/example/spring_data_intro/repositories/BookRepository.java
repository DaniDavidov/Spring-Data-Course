package com.example.spring_data_intro.repositories;

import com.example.spring_data_intro.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByReleaseDateAfter(LocalDate date);

    List<Book> findByReleaseDateBefore(LocalDate date);
}
