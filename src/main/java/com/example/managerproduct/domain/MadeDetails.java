package com.example.managerproduct.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "made_details", schema = "linh_manager", catalog = "")
@IdClass(MadeDetailsPK.class)
public class MadeDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "made_id")
    private int madeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pro_id")
    private int proId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "made_id", referencedColumnName = "made_id", nullable = false,  insertable = false, updatable = false)
    private MadeBy madeByByMadeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id", nullable = false,  insertable = false, updatable = false)
    private Product productByProId;

    public int getMadeId() {
        return madeId;
    }

    public void setMadeId(int madeId) {
        this.madeId = madeId;
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

        MadeDetails that = (MadeDetails) o;

        if (madeId != that.madeId) return false;
        if (proId != that.proId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = madeId;
        result = 31 * result + proId;
        return result;
    }

    public MadeBy getMadeByByMadeId() {
        return madeByByMadeId;
    }

    public void setMadeByByMadeId(MadeBy madeByByMadeId) {
        this.madeByByMadeId = madeByByMadeId;
    }

    public Product getProductByProId() {
        return productByProId;
    }

    public void setProductByProId(Product productByProId) {
        this.productByProId = productByProId;
    }
}
