package com.foodlist.esengine.resource;

import com.foodlist.esengine.model.document.Ingredient;
import com.foodlist.esengine.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/ingredient")
public class IngredientResource {

    private final IngredientService ingredientService;

    @GetMapping("/{name}")
    public List<UUID> getIngredientsByName(@PathVariable String name) {
        return ingredientService.findByName(name).stream().map(Ingredient::getUuid).toList();
    }
}
