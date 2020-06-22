package com.algaworks.algamoney.api.controllers;

import com.algaworks.algamoney.api.models.Category;
import com.algaworks.algamoney.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{code}")
    public Optional<Category> categoryByCode(@PathVariable Long code){
        return categoryRepository.findById(code);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category,
                                 HttpServletResponse request){
        Category newCategory = categoryRepository.save(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
                    .buildAndExpand(newCategory.getCategoryCode()).toUri();

        request.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(newCategory);
    }
}
