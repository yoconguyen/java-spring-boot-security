package com.example.rest;

import com.example.dto.NewsDto;
import com.example.dto.ReponsiDto;
import com.example.dto.SendMail;
import com.example.entities.NewsPage;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsRest {
    @Autowired
    NewsService service;

    @PostMapping("/create/news")
    public NewsPage createNews(@RequestBody NewsDto newsDto) {
        return service.createNews(newsDto);
    }

    @DeleteMapping("/delete/news/{id}")
    public List<NewsPage> delateNews(@PathVariable Long id) {
        return service.deleteNews(id);
    }

    @PutMapping("/update/news")
    public List<NewsPage> updateNews(@RequestBody NewsDto newsDto) {
        return service.updateNews(newsDto);
    }

    @PostMapping("sendMail/news")
    public ReponsiDto SendMailNews(@RequestBody SendMail sendMail) {
        return service.sendSimpleMessage(sendMail);
    }
}
