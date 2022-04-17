package com.example.managerproduct.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "delivery_details", schema = "linh_manager", catalog = "")
@IdClass(DeliveryDetailsPK.class)
public class DeliveryDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "deliv_id")
    private int delivId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pro_id")
    private int proId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "price")
    private Long price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "deliv_id", referencedColumnName = "deliv_id", nullable = false,  insertable = false, updatable = false)
    private Delivery deliveryByDelivId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", nullable = false,  insertable = false, updatable = false)
    private Product productByProId;

    public int getDelivId() {
        return delivId;
    }

    public void setDelivId(int delivId) {
        this.delivId = delivId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryDetails that = (DeliveryDetails) o;

        if (delivId != that.delivId) return false;
        if (proId != that.proId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = delivId;
        result = 31 * result + proId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Delivery getDeliveryByDelivId() {
        return deliveryByDelivId;
    }

    public void setDeliveryByDelivId(Delivery deliveryByDelivId) {
        this.deliveryByDelivId = deliveryByDelivId;
    }

    public Product getProductByProId() {
        return productByProId;
    }

    public void setProductByProId(Product productByProId) {
        this.productByProId = productByProId;
    }
}
