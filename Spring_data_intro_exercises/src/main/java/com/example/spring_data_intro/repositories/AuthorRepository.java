package com.example.spring_data_intro.repositories;

import com.example.spring_data_intro.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    Optional<Author> findById(Long llong);
}
