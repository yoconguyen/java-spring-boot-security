package com.example.dto;

import lombok.Data;

@Data
public class SendMail {
    private String email;
    private String title;
        private String contentMail;
}
