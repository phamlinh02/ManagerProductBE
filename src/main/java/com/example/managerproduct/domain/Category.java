package com.example.managerproduct.domain;

import com.example.managerproduct.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
  name = "findCategory",
  query = "Select c.cate_id id, c.cate_name name, sum(p.quantity) sumQuantity from" +
    " category c join product p on c.cate_id = p.cate_id" +
    " where c.disable =0 " +
    " group by c.cate_id, c.cate_name",
  resultSetMapping = "findSumQuantityOfCategory"
)

@SqlResultSetMapping(
  name ="findSumQuantityOfCategory",
  classes = @ConstructorResult(
    targetClass = CategoryDTO.class,
    columns = {
      @ColumnResult(name = "id", type =Integer.class),
      @ColumnResult(name = "name", type = String.class),
      @ColumnResult(name = "sumQuantity", type = Integer.class)
    }
  )
)

@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cate_id")
    private int cateId;
    @Basic
    @Column(name = "cate_name")
    private String cateName;
    @Basic
    @Column(name = "disable")
    private Integer disable;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryByCateId")
    private Collection<Product> productsByCateId;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
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

        Category category = (Category) o;

        if (cateId != category.cateId) return false;
        if (cateName != null ? !cateName.equals(category.cateName) : category.cateName != null) return false;
        if (disable != null ? !disable.equals(category.disable) : category.disable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + (cateName != null ? cateName.hashCode() : 0);
        result = 31 * result + (disable != null ? disable.hashCode() : 0);
        return result;
    }

    public Collection<Product> getProductsByCateId() {
        return productsByCateId;
    }

    public void setProductsByCateId(Collection<Product> productsByCateId) {
        this.productsByCateId = productsByCateId;
    }
}
