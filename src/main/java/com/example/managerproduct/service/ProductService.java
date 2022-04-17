package com.example.managerproduct.service;

import com.example.managerproduct.domain.Product;
import com.example.managerproduct.dto.ProductDTO;
import com.example.managerproduct.response.*;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ModelMapper modelMapper = new ModelMapper();
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private UnitRepository unitRepository;
    private MadeDetailsRepository madeDetailsRepository;
    private MadeByRepository madeByRepository;
    private SupplierRepository supplierRepository;

    public ProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository,
            UnitRepository unitRepository,
            MadeByRepository madeByRepository,
            MadeDetailsRepository madeDetailsRepository,
            SupplierRepository supplierRepository
    ) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.unitRepository = unitRepository;
        this.madeByRepository = madeByRepository;
        this.madeDetailsRepository = madeDetailsRepository;
        this.supplierRepository = supplierRepository;

    }

    public List<ProductDTO> getAllProduct(){

        return this.productRepository.getAll();
    }

    public List<ProductDTO> getProductByName(String name){
        return this.productRepository.getAll()
                .stream()
                .filter( productDTO -> productDTO.getProName().contains(name))
                .collect(Collectors.toList());
    }



    public List<ProductDTO> getProductAroundQuantity(int start, int end){
        return this.productRepository.getAll()
                .stream()
                .filter( x -> x.getQuantity() >= start)
                .filter(x -> x.getQuantity() <= end)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductAroundPrice(long start, long end){
        return this.productRepository.getAll()
                .stream()
                .filter(x -> x.getPrice() >= start)
                .filter(x -> x.getPrice() <= end)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCateName( String name){
        return this.productRepository.getAll()
                .stream()
                .filter(x -> x.getCateName().equals(name))
                .collect(Collectors.toList());
    }

//    public List<ProductDTO> getProductByEmpName(String name){
//        return this.productRepository.getAll()
//                .stream()
//                .filter(x -> x.getEmpName().equals(name))
//                .collect(Collectors.toList());
//    }

    private Product getProductFromDTO(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

    public ProductDTO saveProduct(ProductDTO productDTO){
        Product product = getProductFromDTO(productDTO);
        product.setCateId(this.categoryRepository.findCategoryByCateName(productDTO.getCateName()).getCateId());
        product.setUnitId(this.unitRepository.findUnitByUnitName(productDTO.getUnitName()).getUnitId());
//        product.setSupplierId(this.supplierRepository.findSupplierBySupplierName(productDTO.getSupplierName()).getSupplierId());
        product.setMadeId(this.madeByRepository.findMadeByMadeName(productDTO.getMadeName()).getMadeId());
        product = this.productRepository.save(product);
        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO update(ProductDTO productDTO, int id){
        if(this.productRepository.findById(id).isPresent()){
            Product product = getProductFromDTO(productDTO);
            product.setCateId(this.categoryRepository.findCategoryByCateName(productDTO.getCateName()).getCateId());
            product.setUnitId(this.unitRepository.findUnitByUnitName(productDTO.getUnitName()).getUnitId());
//            product.setSupplierId(this.supplierRepository.findSupplierBySupplierName(productDTO.getSupplierName()).getSupplierId());
            product.setMadeId(this.madeByRepository.findMadeByMadeName(productDTO.getMadeName()).getMadeId());
            product.setDisable(productDTO.getDisable());
            product = this.productRepository.save(product);
            return modelMapper.map(product, ProductDTO.class);
        } else{
            return null;
        }
    }

    public ProductDTO deleteProduct(int id){
    Product product = this.productRepository.findProductByProId(id);
    product.setDisable(1);
    product = this.productRepository.save(product);
    return modelMapper.map(product, ProductDTO.class);
    }

}
