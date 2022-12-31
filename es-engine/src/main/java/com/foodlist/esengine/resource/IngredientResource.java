package com.foodlist.esengine.resource;

import com.foodlist.esengine.model.document.Ingredient;
import com.foodlist.esengine.service.IngredientService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ingredient")
public class IngredientResource {

//    private final IngredientService ingredientService;
//    private final DiscoveryClient discoveryClient;

//    @PostMapping
//    public void saveIngredient(Ingredient ingredient) {
//        ingredientService.createIngredient(ingredient);
//    }
//
//    @GetMapping
//    public List<Ingredient> findByName(@RequestParam String name) {
//        return ingredientService.findByName(name);
//    }

    @GetMapping("/test")
    public String testController() {
        return "test from eureka client";
    }
}
