package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;

    @Autowired
    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    public void _01_selectShampoosBySize() {
        shampooService.selectBySize(Size.MEDIUM).forEach(System.out::println);
    }

    public void _02_selectShampooBySizeOrLabel() {
        shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10).forEach(System.out::println);
    }

    public void _03_selectShampoosByPrice() {
        shampooService.selectByPriceMoreExpensiveThan(BigDecimal.valueOf(5)).forEach(System.out::println);
    }

    public void _04_selectIngredientsByName(String letter) {
        ingredientService.findIngredientByLetter(letter).forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    public void _05_selectIngredientsByNames() {
        ingredientService.findByNames(new ArrayList<>(List.of("Lavender", "Herbs", "Apple")))
                .forEach(ingredient -> System.out.println(ingredient.getName()));
    }

    public void _06_countShampoosByPrice() {
        int count = shampooService.countShampoosWithPriceLowerThan(BigDecimal.valueOf(8.50));
        System.out.println(count);
    }

    public void _07_selectShampoosByIngredients() {
    }

    public void _08_selectShampoosByIngredientsCount() {
        shampooService.selectByIngredientsCount(2).forEach(System.out::println);
    }

    public void _09_deleteIngredientsByName() {
        ingredientService.deleteIngredientByName("Zinc Pyrithione");
    }

    public void _10_updateIngredientsByPrice() {
        ingredientService.increaseIngredientPrice();
    }
}
