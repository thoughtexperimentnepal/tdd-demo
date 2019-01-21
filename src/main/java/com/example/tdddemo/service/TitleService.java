package com.example.tdddemo.service;

import com.example.tdddemo.client.TitleClient;
import com.example.tdddemo.model.dto.title.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleService {

    TitleClient titleClient;

    public TitleService(TitleClient titleClient){
        this.titleClient = titleClient;
    }

    public Boolean getStatus(Integer id) {
        TitleDto titleDto = titleClient.getTitle(id);
        return titleDto.getCompleted();
    }
}
