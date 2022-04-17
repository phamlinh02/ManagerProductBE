package com.example.managerproduct.service;

import com.example.managerproduct.domain.Category;
import com.example.managerproduct.dto.CategoryDTO;
import com.example.managerproduct.exception.ResourceNotFoundException;
import com.example.managerproduct.response.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> getAll(){
    return this.categoryRepository.findAll();
  }

  public List<CategoryDTO> getCateByName(String name){
    return this.getListCate().stream()
      .filter(categoryDTO -> categoryDTO.getName().contains(name))
      .collect(Collectors.toList());
  }


  public List<CategoryDTO> getListCate(){
    return this.categoryRepository.getAllCate();
  }

  public Category saveCate(Category category){
    return this.categoryRepository.save(category);
  }

  public Category updateCategory(Category category, int id){
    Category cate = this.categoryRepository.findById(id).orElseThrow(
      () -> new ResourceNotFoundException("Category", "id", id));

    cate.setCateName(category.getCateName());
    cate.setDisable(category.getDisable());

    return this.categoryRepository.save(cate);
  }

  public void deleteCategory(int id){
    Category category = this.categoryRepository.getById(id);
    category.setDisable(1);            
  }

}
