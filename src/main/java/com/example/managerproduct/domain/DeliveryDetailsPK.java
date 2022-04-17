package com.example.managerproduct.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class DeliveryDetailsPK implements Serializable {
    @Column(name = "deliv_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivId;
    @Column(name = "pro_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryDetailsPK that = (DeliveryDetailsPK) o;

        if (delivId != that.delivId) return false;
        if (proId != that.proId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = delivId;
        result = 31 * result + proId;
        return result;
    }
}
