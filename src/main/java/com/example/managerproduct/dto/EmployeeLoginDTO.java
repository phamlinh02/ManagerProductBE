package com.example.managerproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeLoginDTO {
  private int id;
  private String username;
  private String password;
}
