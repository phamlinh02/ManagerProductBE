package com.example.managerproduct.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class MadeDetailsPK implements Serializable {
    @Column(name = "made_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madeId;
    @Column(name = "pro_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proId;

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

        MadeDetailsPK that = (MadeDetailsPK) o;

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
}
