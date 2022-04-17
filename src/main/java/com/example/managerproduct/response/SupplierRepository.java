package com.example.managerproduct.response;

import com.example.managerproduct.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    Supplier findSupplierBySupplierName(String name);
}