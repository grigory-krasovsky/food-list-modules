package com.foodlist.esengine.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class PropsService {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private String port;

    public String getElasticUrl() {
        return host + ":" + port;
    }
}
