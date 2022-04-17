package com.example.managerproduct.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "received_details", schema = "linh_manager", catalog = "")
@IdClass(ReceivedDetailsPK.class)
public class ReceivedDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rec_id")
    private int recId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pro_id")
    private int proId;
    @Basic
    @Column(name = "price")
    private Long price;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rec_id", referencedColumnName = "rec_id", nullable = false,  insertable = false, updatable = false)
    private Received receivedByRecId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", nullable = false,  insertable = false, updatable = false)
    private Product productByProId;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceivedDetails that = (ReceivedDetails) o;

        if (recId != that.recId) return false;
        if (proId != that.proId) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + proId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    public Received getReceivedByRecId() {
        return receivedByRecId;
    }

    public void setReceivedByRecId(Received receivedByRecId) {
        this.receivedByRecId = receivedByRecId;
    }

    public Product getProductByProId() {
        return productByProId;
    }

    public void setProductByProId(Product productByProId) {
        this.productByProId = productByProId;
    }
}
