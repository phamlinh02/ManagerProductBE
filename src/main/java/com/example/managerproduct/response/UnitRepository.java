package com.example.managerproduct.response;

import com.example.managerproduct.domain.Unit;
import com.example.managerproduct.dto.UnitDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Unit findUnitByUnitName(String name);

    @Query(name="findAllUnit", nativeQuery = true)
    List<UnitDTO> getAll();
}