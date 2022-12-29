package com.foodlist.esengine.service;

import com.foodlist.esengine.model.document.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class IngredientServiceTest {

    @Autowired
    IngredientService ingredientService;

    @Test
    public void createNewTest() {
        Ingredient ingredient = new Ingredient(UUID.randomUUID(), "перца");
        ingredientService.createIngredient(ingredient);
        List<Ingredient> testIngredientList = ingredientService.findByName("перец");
    }

    @Test
    public void getAll() {
        ingredientService.findAll();
    }
}