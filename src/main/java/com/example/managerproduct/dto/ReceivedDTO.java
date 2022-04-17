package com.example.managerproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceivedDTO {

    private int recId;
    private Long sumPrice;
    private Integer sumQuantity;
    private String recDate;
    private int empId;
    private String empName;


}
