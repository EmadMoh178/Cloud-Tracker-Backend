package com.example.cloud_tracker.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.cloud_tracker.model.Blog;
import com.example.cloud_tracker.repository.BlogRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BlogServiceTest {

  @Mock private BlogRepository blogRepository;

  @InjectMocks private BlogService blogService;

  @Test
  void testGetBlogs() {

    List<Blog> mockBlogs = new ArrayList<>();
    mockBlogs.add(new Blog(1, "<html>blog1</html>"));
    mockBlogs.add(new Blog(2, "<html>blog2</html>"));

    when(blogRepository.findAll()).thenReturn(mockBlogs);

    ArrayList<String> result = blogService.getBlogs();

    assertEquals(2, result.size());
    assertEquals("<html>blog1</html>", result.get(0));
    assertEquals("<html>blog2</html>", result.get(1));

    verify(blogRepository, times(1)).findAll();
  }

  @Test
  void testGetBlogById() {
    List<Blog> mockBlogs = new ArrayList<>();
    mockBlogs.add(new Blog(1, "htmlcontent1"));

    when(blogRepository.findById(1)).thenReturn(Optional.of(mockBlogs.get(0)));

    Optional<Blog> blog1 = blogRepository.findById(1);
    assertTrue(blog1.isPresent());
    assertEquals(1, blog1.get().getId());
    assertEquals("htmlcontent1", blog1.get().getHtmlContent());

    verify(blogRepository, times(1)).findById(1);
  }

  @Test
  public void testSaveBlog() {

    String htmlContent = "<html>Test HTML Content</html>";

    when(blogRepository.save(any())).thenReturn(new Blog());

    ResponseEntity<String> response = blogService.saveBlog(htmlContent);

    verify(blogRepository, times(1)).save(any());

    assertEquals("Blog saved successfully", response.getBody());
    assertEquals(200, response.getStatusCode().value());
  }

  @Test
  public void testSaveBlogWithNullContent() {

    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, () -> blogService.saveBlog(null));

    assertEquals("htmlContent cannot be null", exception.getMessage());

    verify(blogRepository, never()).save(any());
  }
}
