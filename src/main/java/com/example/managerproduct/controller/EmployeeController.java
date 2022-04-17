package com.example.managerproduct.controller;

import com.example.managerproduct.domain.Role;
import com.example.managerproduct.dto.EmployeeDTO;
import com.example.managerproduct.dto.RoleDTO;
import com.example.managerproduct.service.EmployeeService;
import com.example.managerproduct.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee/")
public class EmployeeController {

  private final EmployeeService employeeService;
  private final RoleService roleService;


  public EmployeeController(EmployeeService employeeService, RoleService roleService) {
    this.employeeService = employeeService;
    this.roleService = roleService;
  }

  @GetMapping("all")
  public ResponseEntity<List<EmployeeDTO>> getAll(){
    return new ResponseEntity<>(this.employeeService.getEmployee(), HttpStatus.OK);
  }

  @GetMapping("find-by-name/{name}")
  public ResponseEntity<List<EmployeeDTO>> getEmployeeByName(
    @PathVariable("name") String name
  ){
    return new ResponseEntity<>(this.employeeService.getByName(name), HttpStatus.OK);
  }

  @GetMapping("role/fill-cbo")
  public ResponseEntity<List<RoleDTO>> getRole(
  ){
    return new ResponseEntity<>(this.roleService.getAll(), HttpStatus.OK);
  }

  @PostMapping("save-employee")
  public ResponseEntity<EmployeeDTO> saveEmployee(
    @RequestBody EmployeeDTO employeeDTO
  ){
    return new ResponseEntity<>(this.employeeService.saveEmployee(employeeDTO), HttpStatus.CREATED);
  }

  @PutMapping("update-employee/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(
    @RequestBody EmployeeDTO employeeDTO,
    @PathVariable("id") int id
  ){
    return new ResponseEntity<>(this.employeeService.updateEmployee(employeeDTO, id), HttpStatus.CREATED);
  }

  @PostMapping("delete-employee/{id}")
  public ResponseEntity<EmployeeDTO> deleteEmployee(
    @PathVariable("id") int id
  ){
    return new ResponseEntity<>(this.employeeService.deleteEmployee(id), HttpStatus.OK);
  }
}
