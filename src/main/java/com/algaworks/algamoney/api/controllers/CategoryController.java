package com.algaworks.algamoney.api.controllers;

import com.algaworks.algamoney.api.enums.ExceptionEnum;
import com.algaworks.algamoney.api.exceptions.ResourceNotFound;
import com.algaworks.algamoney.api.models.Category;
import com.algaworks.algamoney.api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
    public Category categoryByCode(@PathVariable Long code){
        return  categoryRepository
                .findById(code)
                .orElseThrow(() -> new ResourceNotFound(ExceptionEnum.BAD_REQUEST_MESSAGE.getHttpErrors()));

//        Optional<Category> category = categoryRepository.findById(code);
//        return category.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category,
                                 HttpServletResponse request){
        Category newCategory = categoryRepository.saveAndFlush(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{code}")
                    .buildAndExpand(newCategory.getCategoryCode()).toUri();

        request.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(newCategory);
    }
}
