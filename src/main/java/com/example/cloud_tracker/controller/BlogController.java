package com.example.cloud_tracker.controller;

import com.example.cloud_tracker.dto.BlogDTO;
import com.example.cloud_tracker.model.Blog;
import com.example.cloud_tracker.service.BlogService;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

  @Autowired private BlogService blogService;

  @PostMapping("/blog")
  public ResponseEntity<String> saveBlog(@RequestBody @NotNull BlogDTO content) {
    return blogService.saveBlog(content.getHtmlContent());
  }

  @GetMapping("/blog/all")
  public ArrayList<String> getBlog() {
    return blogService.getBlogs();
  }

  @GetMapping("/blog/{id}")
  public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
    Optional<Blog> optionalContent = blogService.getBlogById(id);
    return optionalContent.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
}
