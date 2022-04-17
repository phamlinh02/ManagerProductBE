package com.example.managerproduct.controller;

import com.example.managerproduct.domain.MadeBy;
import com.example.managerproduct.domain.Product;
import com.example.managerproduct.dto.MadeByDTO;
import com.example.managerproduct.dto.ProductDTO;
import com.example.managerproduct.dto.UnitDTO;
import com.example.managerproduct.service.MadeService;
import com.example.managerproduct.service.ProductService;
import com.example.managerproduct.service.UnitService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product/")
public class ProductController {

    ProductService productService;
    UnitService unitService;
    MadeService madeService;

    public ProductController(ProductService productService, UnitService unitService, MadeService madeService) {
        this.productService = productService;
        this.unitService = unitService;
        this.madeService = madeService;
    }


    @GetMapping("all")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return new ResponseEntity<>(this.productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("find-by-name")
    public ResponseEntity<List<ProductDTO>> getProductByName(
            @RequestParam  String name
    ){
        return new ResponseEntity<>(this.productService.getProductByName(name), HttpStatus.OK);
    }

    @GetMapping("find-around-quantity")
    public ResponseEntity<List<ProductDTO>> getProductAroundQuantity(
            @RequestParam int start,
            @RequestParam int end
    ){
        return new ResponseEntity<>(this.productService.getProductAroundQuantity(start,end), HttpStatus.OK);
    }

    @GetMapping("find-around-price")
    public ResponseEntity<List<ProductDTO>> getProductAroundQuantity(
            @RequestParam long start,
            @RequestParam long end
    ){
        return new ResponseEntity<>(this.productService.getProductAroundPrice(start, end), HttpStatus.OK);
    }

    @GetMapping("find-by-cateName")
    public ResponseEntity<List<ProductDTO>> getProductByCateName(
            @RequestParam String name
    ){
        return new ResponseEntity<>(this.productService.getProductByCateName(name), HttpStatus.OK);
    }
//
//    @GetMapping("find-by-empName")
//    public ResponseEntity<List<ProductDTO>> getProductByEmpName(
//            @RequestParam String name
//    ){
//        return new ResponseEntity<>(this.productService.getProductByEmpName(name), HttpStatus.OK);
//    }

    //unit and made

    @GetMapping("unit/fill-cbo")
    public ResponseEntity<List<UnitDTO>> fillCboUnit(){
        return new ResponseEntity<>(this.unitService.getAll(), HttpStatus.OK);
    }

    @GetMapping("made/fill-cbo")
    public ResponseEntity<List<MadeByDTO>> fillCboMade(){
        return new ResponseEntity<>(this.madeService.getAll(), HttpStatus.OK);
    }
    @PostMapping("create-product")
    public ResponseEntity<ProductDTO> saveProduct(
            @RequestBody ProductDTO productDTO
    ){
        return new ResponseEntity<>(this.productService.saveProduct(productDTO), HttpStatus.CREATED);
    }

    @PutMapping("update-product/{id}")
    public  ResponseEntity<ProductDTO> updateProduct(
            @RequestBody ProductDTO productDTO,
            @PathVariable("id") int id

    ){
        return new ResponseEntity<>(this.productService.update(productDTO,id), HttpStatus.OK);
    }

    @PutMapping("delete-product/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(
            @PathVariable("id") int id
    ){
        return new ResponseEntity<>(this.productService.deleteProduct(id), HttpStatus.OK);
    }


}
