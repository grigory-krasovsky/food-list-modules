package com.foodlist.esengine.service;

import com.foodlist.esengine.model.document.Ingredient;
import com.foodlist.esengine.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public void createIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findByName(String name) {
        return ingredientRepository.findAllByName(name);
    }

    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        return ingredients;
    }
}
