package com.foodlist.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
