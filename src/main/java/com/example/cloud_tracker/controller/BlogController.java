package com.example.cloud_tracker.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cloud_tracker.dto.BlogDTO;
import com.example.cloud_tracker.service.BlogService;

import jakarta.validation.constraints.NotNull;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> saveBlog(@RequestBody @NotNull BlogDTO content) {
        return blogService.saveBlog(content.getHtmlContent());
    }

    @GetMapping("/blog/all")
    public ArrayList<String> getBlog() {
        return blogService.getBlogs();
    }
}
