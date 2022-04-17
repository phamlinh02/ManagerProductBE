package com.example.managerproduct.domain;

import com.example.managerproduct.dto.UnitDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "findAllUnit",
        query = "select u.unit_id unitId, u.unit_name unitName from unit u ",
        resultSetMapping = "fillCbo"

)

@SqlResultSetMapping(
        name = "fillCbo",
        classes = @ConstructorResult(
                targetClass = UnitDTO.class,
                columns = {
                        @ColumnResult(name = "unitId", type = Integer.class),
                        @ColumnResult(name ="unitName", type = String.class)
                }
        )
)

@Entity
@Table(name = "unit")
public class Unit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "unit_id")
    private int unitId;
    @Basic
    @Column(name = "unit_name")
    private String unitName;

    @JsonIgnore
    @OneToMany(mappedBy = "unitByUnitId")
    private Collection<Product> productsByUnitId;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit unit = (Unit) o;

        if (unitId != unit.unitId) return false;
        if (unitName != null ? !unitName.equals(unit.unitName) : unit.unitName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        return result;
    }

    public Collection<Product> getProductsByUnitId() {
        return productsByUnitId;
    }

    public void setProductsByUnitId(Collection<Product> productsByUnitId) {
        this.productsByUnitId = productsByUnitId;
    }
}
