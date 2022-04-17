package com.example.managerproduct.response;

import com.example.managerproduct.domain.Role;
import com.example.managerproduct.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(name = "fillCboRole", nativeQuery = true)
    List<RoleDTO> getAll();
}