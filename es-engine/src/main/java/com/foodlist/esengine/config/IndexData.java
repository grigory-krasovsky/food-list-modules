package com.foodlist.esengine.config;

public enum IndexData {
    INGREDIENT(Names.INGREDIENT);

    public class Names {
        public static final String INGREDIENT = "ingredient";
    }

    private final String indexName;

    IndexData(String indexName) {
        this.indexName = indexName;
    }

}
