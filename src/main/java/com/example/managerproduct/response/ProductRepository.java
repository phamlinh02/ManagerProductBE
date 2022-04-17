package com.example.managerproduct.response;

import com.example.managerproduct.domain.Product;
import com.example.managerproduct.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(name = "findAll", nativeQuery = true)
    List<ProductDTO> getAll();

    Product findProductByProId(int id);



}
