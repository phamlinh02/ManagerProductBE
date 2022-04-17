package com.example.managerproduct.domain;


import com.example.managerproduct.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "findAll",
        query = "SELECT p.pro_id proId, p.pro_name proName, p.price price, p.quantity quantity, u.unit_name unitName" +
                " ,c.cate_name cateName ,m.made_name madeName  " +
                "from product p join category c on c.cate_id = p.cate_id  " +
                "join unit u on u.unit_id = p.unit_id " +
                "join made_by m on m.made_id = p.made_id " +
                "WHERE p.disable =0",
        resultSetMapping = "findAllProduct"
)

@SqlResultSetMapping(
        name = "findAllProduct",
        classes = @ConstructorResult(
                targetClass = ProductDTO.class,
                columns = {
                        @ColumnResult(name ="proId", type = Integer.class),
                        @ColumnResult(name ="proName", type = String.class),
                        @ColumnResult(name = "price", type = Long.class),
                        @ColumnResult(name =" quantity", type = Integer.class),
                        @ColumnResult(name = "unitName", type = String.class),
                        @ColumnResult(name = "cateName", type = String.class),
                        @ColumnResult(name = "madeName", type = String.class),

                }
        )
)
@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pro_id")
    private int proId;
    @Basic
    @Column(name = "pro_name")
    private String proName;
    @Basic
    @Column(name = "cate_id")
    private Integer cateId;
    @Basic
    @Column(name = "unit_id")
    private Integer unitId;
    @Basic
    @Column(name = "price")
    private Long price;
    @Basic
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Basic
    @Column(name = "made_id")
    private Integer madeId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "disable")
    private Integer disable;

    @JsonIgnore
    @OneToMany(mappedBy = "productByProId")
    private Collection<DeliveryDetails> deliveryDetailsByProId;

    @JsonIgnore
    @OneToMany(mappedBy = "productByProId")
    private Collection<MadeDetails> madeDetailsByProId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id",  insertable = false, updatable = false)
    private Category categoryByCateId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id",  insertable = false, updatable = false)
    private Unit unitByUnitId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id",  insertable = false, updatable = false)
    private Supplier supplierBySupplierId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "made_id", referencedColumnName = "made_id",  insertable = false, updatable = false)
    private MadeBy madeByByMadeId;

    @JsonIgnore
    @OneToMany(mappedBy = "productByProId")
    private Collection<ReceivedDetails> receivedDetailsByProId;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getMadeId() {
        return madeId;
    }

    public void setMadeId(Integer madeId) {
        this.madeId = madeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (proId != product.proId) return false;
        if (proName != null ? !proName.equals(product.proName) : product.proName != null) return false;
        if (cateId != null ? !cateId.equals(product.cateId) : product.cateId != null) return false;
        if (unitId != null ? !unitId.equals(product.unitId) : product.unitId != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (supplierId != null ? !supplierId.equals(product.supplierId) : product.supplierId != null) return false;
        if (madeId != null ? !madeId.equals(product.madeId) : product.madeId != null) return false;
        if (quantity != null ? !quantity.equals(product.quantity) : product.quantity != null) return false;
        if (disable != null ? !disable.equals(product.disable) : product.disable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proId;
        result = 31 * result + (proName != null ? proName.hashCode() : 0);
        result = 31 * result + (cateId != null ? cateId.hashCode() : 0);
        result = 31 * result + (unitId != null ? unitId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (madeId != null ? madeId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (disable != null ? disable.hashCode() : 0);
        return result;
    }

    public Collection<DeliveryDetails> getDeliveryDetailsByProId() {
        return deliveryDetailsByProId;
    }

    public void setDeliveryDetailsByProId(Collection<DeliveryDetails> deliveryDetailsByProId) {
        this.deliveryDetailsByProId = deliveryDetailsByProId;
    }

    public Collection<MadeDetails> getMadeDetailsByProId() {
        return madeDetailsByProId;
    }

    public void setMadeDetailsByProId(Collection<MadeDetails> madeDetailsByProId) {
        this.madeDetailsByProId = madeDetailsByProId;
    }

    public Category getCategoryByCateId() {
        return categoryByCateId;
    }

    public void setCategoryByCateId(Category categoryByCateId) {
        this.categoryByCateId = categoryByCateId;
    }

    public Unit getUnitByUnitId() {
        return unitByUnitId;
    }

    public void setUnitByUnitId(Unit unitByUnitId) {
        this.unitByUnitId = unitByUnitId;
    }

    public Supplier getSupplierBySupplierId() {
        return supplierBySupplierId;
    }

    public void setSupplierBySupplierId(Supplier supplierBySupplierId) {
        this.supplierBySupplierId = supplierBySupplierId;
    }

    public MadeBy getMadeByByMadeId() {
        return madeByByMadeId;
    }

    public void setMadeByByMadeId(MadeBy madeByByMadeId) {
        this.madeByByMadeId = madeByByMadeId;
    }

    public Collection<ReceivedDetails> getReceivedDetailsByProId() {
        return receivedDetailsByProId;
    }

    public void setReceivedDetailsByProId(Collection<ReceivedDetails> receivedDetailsByProId) {
        this.receivedDetailsByProId = receivedDetailsByProId;
    }
}
