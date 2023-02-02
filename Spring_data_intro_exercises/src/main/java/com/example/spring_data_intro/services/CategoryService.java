package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

}
