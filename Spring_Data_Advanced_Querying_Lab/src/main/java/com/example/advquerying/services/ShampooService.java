package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectBySize(Size size);

    List<Shampoo> selectBySizeOrLabelId(Size size, long labelId);

    List<Shampoo> selectByPriceMoreExpensiveThan(BigDecimal price);

    int countShampoosWithPriceLowerThan(BigDecimal price);

    List<Shampoo> selectByIngredientsCount(int count);
}
