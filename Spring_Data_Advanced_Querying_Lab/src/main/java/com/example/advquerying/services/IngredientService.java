package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findIngredientByLetter(String letter);

    List<Ingredient> findByNames(List<String> names);

    List<Shampoo> findByIngredients(List<Ingredient> ingredients);

    void deleteIngredientByName(String name);

    void increaseIngredientPrice();
}
