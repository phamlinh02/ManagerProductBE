package com.example.managerproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

  private int empId;
  private String empName;
  private String username;
  private String email;
  private String phone;
  private int role;
  private int disable;
  private String password;
  private String roleName;


  public EmployeeDTO(int empId,String empName, String username, String email, String phone, int role, int disable) {
    this.empId = empId;
    this.empName = empName;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.role = role;
    this.disable = disable;
  }
}
