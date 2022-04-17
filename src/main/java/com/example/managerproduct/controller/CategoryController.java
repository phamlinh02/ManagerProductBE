package com.example.managerproduct.controller;

import com.example.managerproduct.domain.Category;
import com.example.managerproduct.dto.CategoryDTO;
import com.example.managerproduct.response.CategoryRepository;
import com.example.managerproduct.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product/category/")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
this.categoryService = categoryService;
  }

  @GetMapping("fill-cbo")
  public ResponseEntity<List<Category>> getCateFillCbo(){
    return new ResponseEntity<>(this.categoryService.getAll(), HttpStatus.OK);
  }

  @GetMapping("all")
  public ResponseEntity<List<CategoryDTO>> getAllCategory(){
    return new ResponseEntity<>(this.categoryService.getListCate(), HttpStatus.OK);
  }

  @GetMapping("find-by-name/{name}")
  public ResponseEntity<List<CategoryDTO>> getCategoryByName(
    @PathVariable("name") String name
  ){
    return new ResponseEntity<>(this.categoryService.getCateByName(name), HttpStatus.OK);
  }

  @PostMapping("add-category")
  public ResponseEntity<Category> saveCategory(
    @RequestBody Category category
  ){
    return new ResponseEntity<>(this.categoryService.saveCate(category), HttpStatus.CREATED);
  }

  @PutMapping("update-category")
  public ResponseEntity<Category> updateCategory(
    @RequestBody Category category,
    @RequestParam("id") int id
  ){
    return new ResponseEntity<>(this.categoryService.updateCategory(category, id), HttpStatus.CREATED);
  }

  @DeleteMapping("delete-category")
  public ResponseEntity<String> deleteCategory(
    @RequestParam("id") int id
  ){
    this.categoryService.deleteCategory(id);
    return new ResponseEntity<>("Successfully to delete Category", HttpStatus.OK);
  }


}
