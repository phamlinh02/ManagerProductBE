package com.example.managerproduct.response;

import com.example.managerproduct.domain.Category;
import com.example.managerproduct.dto.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
     Category findCategoryByCateNameLike(String name);
     Category findCategoryByCateName(String name);

     @Query(name ="findCategory", nativeQuery = true)
     List<CategoryDTO> getAllCate();
}

