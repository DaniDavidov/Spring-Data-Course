package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Category;
import com.example.spring_data_intro.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        long count = categoryRepository.count();
        Random random = new Random();

        int categoriesCount = random.nextInt((int) count) + 1;
        Set<Integer> numbers = new LinkedHashSet<>();

        for (int i = 0; i < categoriesCount; i++) {
            numbers.add(random.nextInt((int) count) + 1);
        }

        List<Category> allById = new ArrayList<>();
        for (Integer number : numbers) {
            allById.add(categoryRepository.findById((long) number).get());
        }
        return new HashSet<>(allById);
    }
}
