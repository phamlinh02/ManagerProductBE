package com.example.managerproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {
  private int id;
  private String delivDate;
  private Long sumPrice;
  private Integer sumQuantity;
  private int empId;
  private String empName;
}
