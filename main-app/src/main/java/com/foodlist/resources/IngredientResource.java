package com.foodlist.resources;

import com.foodlist.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
@AllArgsConstructor
public class IngredientResource {

    private final IngredientService ingredientService;

    @GetMapping("/{name}")
    public void getByIngredientName(@PathVariable String name) {
        ingredientService.getByName(name);
    }
}
