package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Author;
import com.example.spring_data_intro.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();
        Random random = new Random();
        long number = random.nextInt((int) size) + 1;
        return authorRepository.findById(number).get();
    }
}
