package com.foodlist.utils;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class PropertiesService {
    @Value("${foodlist.application.es-engine}")
    String esEngineUrl;
}
