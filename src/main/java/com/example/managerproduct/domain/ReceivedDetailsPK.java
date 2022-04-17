package com.example.managerproduct.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ReceivedDetailsPK implements Serializable {
    @Column(name = "rec_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recId;
    @Column(name = "pro_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceivedDetailsPK that = (ReceivedDetailsPK) o;

        if (recId != that.recId) return false;
        if (proId != that.proId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + proId;
        return result;
    }
}
