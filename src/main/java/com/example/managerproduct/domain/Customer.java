package com.example.managerproduct.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "customer_name")
    private String customerName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "sum_price_buy")
    private Long sumPriceBuy;
    @Basic
    @Column(name = "disable")
    private Integer disable;

    @JsonIgnore
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Delivery> deliveriesByCustomerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSumPriceBuy() {
        return sumPriceBuy;
    }

    public void setSumPriceBuy(Long sumPriceBuy) {
        this.sumPriceBuy = sumPriceBuy;
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

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (sumPriceBuy != null ? !sumPriceBuy.equals(customer.sumPriceBuy) : customer.sumPriceBuy != null)
            return false;
        if (disable != null ? !disable.equals(customer.disable) : customer.disable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (sumPriceBuy != null ? sumPriceBuy.hashCode() : 0);
        result = 31 * result + (disable != null ? disable.hashCode() : 0);
        return result;
    }

    public Collection<Delivery> getDeliveriesByCustomerId() {
        return deliveriesByCustomerId;
    }

    public void setDeliveriesByCustomerId(Collection<Delivery> deliveriesByCustomerId) {
        this.deliveriesByCustomerId = deliveriesByCustomerId;
    }
}
