package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AiService {

    public String summary(String content) {

        return "AI总结：今天完成的任务包括：" + content +
                "。整体来看任务完成情况良好。";
    }
}