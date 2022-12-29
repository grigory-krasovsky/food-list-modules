package com.foodlist.esengine.model.template;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Model for creating an Ingredient index if it does not exist.
 */
@Data
@AllArgsConstructor
public class IngredientIndexTemplateModel {

    private Settings settings;
    private Mappings mappings;

    @AllArgsConstructor
    public static class Analysis{
        public Analyzer analyzer;
        public Filter filter;
    }

    @AllArgsConstructor
    public static class Analyzer{
        public CustomAnalyzer custom_analyzer;
    }

    @AllArgsConstructor
    public static class CustomAnalyzer{
        public String tokenizer;
        public List<String> filter;
        public List<String> char_filter;
    }

    @AllArgsConstructor
    public static class Filter{
        public MyStemmer my_stemmer;
        public RuRU ru_RU;
    }

    @AllArgsConstructor
    public static class Mappings{
        public Properties properties;
    }

    @AllArgsConstructor
    public static class MyStemmer{
        public String type;
        public String language;
    }

    @AllArgsConstructor
    public static class Name{
        public String type;
        public String analyzer;
    }

    @AllArgsConstructor
    public static class Properties{
        public Name name;
    }

    @AllArgsConstructor
    public static class Root{
        public Settings settings;
        public Mappings mappings;
    }

    @AllArgsConstructor
    public static class RuRU{
        public String type;
        public String locale;
    }

    @AllArgsConstructor
    public static class Settings{
        public Analysis analysis;
    }

    public static IngredientIndexTemplateModel create() {
        return new IngredientIndexTemplateModel(
                new Settings(
                        new Analysis(
                                new Analyzer(
                                        new CustomAnalyzer(
                                                "standard", List.of("lowercase", "ru_RU", "my_stemmer"),
                                                List.of("html_strip")
                                        )
                                ), new Filter(new MyStemmer("stemmer", "russian"),
                                new RuRU("hunspell", "ru_RU"))
                        )
                ),
                new Mappings(
                        new Properties(
                                new Name("text", "custom_analyzer")
                        )
                )
        );
    }
}
