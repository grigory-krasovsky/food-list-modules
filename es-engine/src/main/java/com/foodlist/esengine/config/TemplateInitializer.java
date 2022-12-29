package com.foodlist.esengine.config;

import com.foodlist.esengine.model.template.IngredientIndexTemplateModel;
import com.foodlist.esengine.utils.PropsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class TemplateInitializer {
    private final RestTemplate restTemplate;
    private final PropsService propsService;

    private final static String INGREDIENT_INDEX_NAME = IndexData.Names.INGREDIENT;

    @Bean
    public void init() {
        if (indexIsAbsent(INGREDIENT_INDEX_NAME)) {
            IngredientIndexTemplateModel model = IngredientIndexTemplateModel.create();
            createIndex(model);
        }
    }

    private void createIndex(IngredientIndexTemplateModel model) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<IngredientIndexTemplateModel> request = new HttpEntity<>(model, headers);
        restTemplate.exchange(buildUrl(INGREDIENT_INDEX_NAME), HttpMethod.PUT, request, Void.class);
    }

    /**
     * Check if index is absent in Elastic search
     */
    private boolean indexIsAbsent(String indexName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        try {
            restTemplate.exchange(buildUrl(indexName), HttpMethod.HEAD, request, Void.class);
        } catch (HttpClientErrorException.NotFound e) {
            return true;
        }
        return false;
    }

    private String buildUrl(String indexName) {
        return "http://" + propsService.getElasticUrl() + "/" + indexName;
    }
}
