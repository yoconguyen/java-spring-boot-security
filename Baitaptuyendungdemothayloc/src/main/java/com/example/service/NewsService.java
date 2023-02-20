package com.example.service;

import com.example.dto.NewsDto;
import com.example.dto.ReponsiDto;
import com.example.dto.SendMail;
import com.example.entities.NewsPage;
import com.example.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service

public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    private JavaMailSender emailSender;
    public NewsPage createNews(NewsDto newsDto){
        NewsPage newsPage = new NewsPage();
        newsPage.setTitle(newsDto.getTitle());
        newsPage.setDescribe(newsDto.getDescribe());
        newsRepository.save(newsPage);
        return newsPage;
    }
    public List<NewsPage> deleteNews(Long id){
        NewsPage newsPage = new NewsPage();
        newsRepository.deleteById(id);
        return newsRepository.findAll();
    }
    public List<NewsPage> updateNews(NewsDto newsDto){

        Optional<NewsPage> newspage = newsRepository.findById(newsDto.getId());
        newspage.get().setDescribe(newsDto.getDescribe());
        newspage.get().setTitle(newsDto.getTitle());

        return newsRepository.findAll();
    }



    public ReponsiDto sendSimpleMessage(SendMail sendMail) {

        SimpleMailMessage message = new SimpleMailMessage();
        ReponsiDto reponsiDto = new ReponsiDto();
        message.setTo(sendMail.getEmail());
        message.setSubject(sendMail.getTitle());
        message.setText(sendMail.getContentMail());
        emailSender.send(message);
        reponsiDto.setCode(200);
        reponsiDto.setObject("thanh cong");
        return reponsiDto;
    }

}


