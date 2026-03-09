package com.example.demo.controller;

import com.example.demo.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/summary")
    public String summary(@RequestBody List<String> tasks) throws Exception {

        String content = String.join(",", tasks);

        return aiService.summary(content);
    }
}