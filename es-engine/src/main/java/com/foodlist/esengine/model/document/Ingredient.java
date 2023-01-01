package com.foodlist.esengine.model.document;

import com.foodlist.esengine.config.IndexData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Document(indexName = IndexData.Names.INGREDIENT, createIndex = false)
@AllArgsConstructor
@Data
public class Ingredient {
    @Id
    private UUID uuid;

    @Field(type = FieldType.Text, name = "name")
    private String name;

}
