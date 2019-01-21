package com.example.tdddemo.client;

import com.example.tdddemo.model.dto.title.TitleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TitleClient {
    RestTemplate restTemplate;
    String titleBaseUrl;

    public TitleClient(RestTemplate restTemplate,
                       @Value("${titleBaseUrl}")String titleBaseUrl
    ){
        this.restTemplate = restTemplate;
        this.titleBaseUrl = titleBaseUrl;
    }

    String path = "/todos";

    public TitleDto getTitle(Integer id){
        TitleDto titleDto = restTemplate.getForObject(titleBaseUrl + path + "/" + id, TitleDto.class);
        return titleDto;
    }
}
