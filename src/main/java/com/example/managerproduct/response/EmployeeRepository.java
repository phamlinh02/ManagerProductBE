package com.example.managerproduct.response;

import com.example.managerproduct.domain.Employee;
import com.example.managerproduct.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee getEmployeeByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<Employee> findOneWithAuthoritiesByUsername(String username);

    @Query(name="getEmployee", nativeQuery = true)
    List<EmployeeDTO> getAll();

    Employee findEmployeeByEmpId(int id);
}
