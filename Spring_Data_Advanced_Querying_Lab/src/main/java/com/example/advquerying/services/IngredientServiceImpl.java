package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findIngredientByLetter(String letter) {
        return ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findByNames(List<String> names) {
        return ingredientRepository.findByNameIn(names);
    }

    @Override
    public List<Shampoo> findByIngredients(List<Ingredient> ingredients) {
        return ingredientRepository.findByIngredientsIn(ingredients);
    }

    @Override
    @Transactional
    public void deleteIngredientByName(String name) {
        ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void increaseIngredientPrice() {
        ingredientRepository.increasePrice();
    }
}
