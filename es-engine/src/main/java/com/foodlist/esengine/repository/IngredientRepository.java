package com.foodlist.esengine.repository;

import com.foodlist.esengine.model.document.Ingredient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface IngredientRepository extends ElasticsearchRepository<Ingredient, UUID> {
    List<Ingredient> findAllByName(String name);
}
