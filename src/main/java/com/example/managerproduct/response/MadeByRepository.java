package com.example.managerproduct.response;

import com.example.managerproduct.domain.MadeBy;
import com.example.managerproduct.dto.MadeByDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MadeByRepository extends JpaRepository<MadeBy, Integer> {
    MadeBy findMadeByMadeName(String name);

    @Query(name ="findAllMade", nativeQuery = true)
    List<MadeByDTO> getAll();
}