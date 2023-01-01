package com.foodlist.services;

import com.foodlist.models.Ingredient;
import com.foodlist.repositories.IngredientRepository;
import com.foodlist.utils.PropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RestTemplate restTemplate;
    private final PropertiesService propertiesService;

    public void addNew(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getByName(String name) {
        UUID[] uuids = restTemplate
                .getForObject(String.format("http://%s/ingredient/%s", propertiesService.getEsEngineUrl(), name), UUID[].class);

        if (uuids == null) {
            throw new RuntimeException("Unable to map to UUID type");
        }

        if (uuids.length == 0) {
            throw new NoSuchElementException("No ingredients with such name were found");
        }

        //Todo make verification for NPE in separate method / maybe in class (DDD)
        return ingredientRepository.findByUuidIn(List.of(uuids));
    }
}
