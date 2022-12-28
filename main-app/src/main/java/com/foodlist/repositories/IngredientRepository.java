package com.foodlist.repositories;

import com.foodlist.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Integer> {
//    Optional<Ingredient> findByName(String name);

    List<Ingredient> findByNameIn(List<String> names);
}
