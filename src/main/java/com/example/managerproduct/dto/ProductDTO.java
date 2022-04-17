package com.example.managerproduct.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private int proId;
    private String proName;
    private Long price;
    private int quantity;
    private String unitName;
    private String cateName;
    private String madeName;
    private int disable;

    public ProductDTO(int proId, String proName, Long price, int quantity, String unitName, String cateName, String madeName, int disable) {
        this.proId = proId;
        this.proName = proName;
        this.price = price;
        this.quantity = quantity;
        this.unitName = unitName;
        this.cateName = cateName;
        this.madeName = madeName;
        this.disable = disable;
    }

    public ProductDTO(int proId, String proName, Long price, int quantity, String unitName, String cateName, String madeName) {
        this.proId = proId;
        this.proName = proName;
        this.price = price;
        this.quantity = quantity;
        this.unitName = unitName;
        this.cateName = cateName;
        this.madeName = madeName;
    }
}
