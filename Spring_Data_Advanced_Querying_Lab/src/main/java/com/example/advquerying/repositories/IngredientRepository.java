package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameIn(List<String> names);

    @Query(value = "select s from Shampoo s" +
                   " join s.ingredients i" +
                   " where i in :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") List<Ingredient> ingredients);

    void deleteByName(@Param(value = "name") String name);

    @Modifying
    @Query(value = "update Ingredient i set i.price = i.price * 1.1")
    void increasePrice();
}
