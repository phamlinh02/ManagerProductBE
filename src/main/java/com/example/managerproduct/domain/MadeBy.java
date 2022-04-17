package com.example.managerproduct.domain;

import com.example.managerproduct.dto.MadeByDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "findAllMade",
        query = "select m.made_id madeId, m.made_name madeName from made_by m",
        resultSetMapping = "fillCboMade"
)

@SqlResultSetMapping(
        name = "fillCboMade",
        classes = @ConstructorResult(
                targetClass = MadeByDTO.class,
                columns = {
                        @ColumnResult(name ="madeId", type = Integer.class),
                        @ColumnResult(name ="madeName", type = String.class)
                }
        )
)

@Entity
@Table(name = "made_by", schema = "linh_manager", catalog = "")
public class MadeBy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "made_id")
    private int madeId;
    @Basic
    @Column(name = "made_name")
    private String madeName;

    @JsonIgnore
    @OneToMany(mappedBy = "madeByByMadeId")
    private Collection<MadeDetails> madeDetailsByMadeId;

    @JsonIgnore
    @OneToMany(mappedBy = "madeByByMadeId")
    private Collection<Product> productsByMadeId;

    public int getMadeId() {
        return madeId;
    }

    public void setMadeId(int madeId) {
        this.madeId = madeId;
    }

    public String getMadeName() {
        return madeName;
    }

    public void setMadeName(String madeName) {
        this.madeName = madeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MadeBy madeBy = (MadeBy) o;

        if (madeId != madeBy.madeId) return false;
        if (madeName != null ? !madeName.equals(madeBy.madeName) : madeBy.madeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = madeId;
        result = 31 * result + (madeName != null ? madeName.hashCode() : 0);
        return result;
    }

    public Collection<MadeDetails> getMadeDetailsByMadeId() {
        return madeDetailsByMadeId;
    }

    public void setMadeDetailsByMadeId(Collection<MadeDetails> madeDetailsByMadeId) {
        this.madeDetailsByMadeId = madeDetailsByMadeId;
    }

    public Collection<Product> getProductsByMadeId() {
        return productsByMadeId;
    }

    public void setProductsByMadeId(Collection<Product> productsByMadeId) {
        this.productsByMadeId = productsByMadeId;
    }
}
