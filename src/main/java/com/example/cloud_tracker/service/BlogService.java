package com.example.cloud_tracker.service;

import com.example.cloud_tracker.model.Blog;
import com.example.cloud_tracker.repository.BlogRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public ResponseEntity<String> saveBlog(String htmlContent) {
        if(htmlContent == null)
            throw new IllegalArgumentException("htmlContent cannot be null");
        
        Blog blog = new Blog();
        blog.setHtmlContent(htmlContent);
        blogRepository.save(blog);
        return ResponseEntity.ok("Blog saved successfully");
    }

    public ArrayList<String> getBlogs() {
        ArrayList<String> blogs = new ArrayList<>();
        List<Blog> blog = blogRepository.findAll();
        for (Blog b : blog) {
            blogs.add(b.getHtmlContent());
        }
        return blogs;
    }
    public Optional <Blog> getBlogById (int id){
        return blogRepository.findById(id);
    }
}
