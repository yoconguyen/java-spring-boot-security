package com.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "news_pages")
@NoArgsConstructor
public class NewsPage{

    @Id
    @GeneratedValue
    @Column(name = "id", length = 8)
    private Long id;

    @Column(name = "title_job")
    private String title;

    @Column(name = "describe_job")
    private String describe;
}
