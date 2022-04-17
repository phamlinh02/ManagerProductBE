package com.example.managerproduct.domain;

import com.example.managerproduct.dto.DeliveryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
  name = "getDelivery",
  query = "select d.deliv_id id, d.deliv_date delivDate, d.sum_price sumPrice , d.sum_quantity sumQuantity" +
    " , e.emp_id empId , e.emp_name empName " +
    " from delivery d join employee e on d.emp_id = e.emp_id ",
  resultSetMapping = "getAllDelivery"
)

@SqlResultSetMapping(
  name = "getAllDelivery",
  classes = @ConstructorResult(
    targetClass = DeliveryDTO.class,
    columns = {
      @ColumnResult(name = "id", type = Integer.class),
      @ColumnResult(name ="delivDate" , type = String.class),
      @ColumnResult(name = "sumPrice", type = Long.class),
      @ColumnResult(name = "sumQuantity", type = Integer.class),
      @ColumnResult(name ="empId", type = Integer.class),
            @ColumnResult(name ="empName", type = String.class)
    }
  )
)

@Entity
@Table(name = "delivery")
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "deliv_id")
    private int delivId;
    @Basic
    @Column(name = "sum_price")
    private Long sumPrice;
    @Basic
    @Column(name = "sum_quantity")
    private Integer sumQuantity;
    @Basic
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic
    @Column(name = "emp_id")
    private Integer empId;
    @Basic
    @Column(name = "deliv_date")
    private String delivDate;
    @Basic
    @Column(name = "note")
    private String note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id",  insertable = false, updatable = false)
    private Customer customerByCustomerId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id",  insertable = false, updatable = false)
    private Employee employeeByEmpId;

    @JsonIgnore
    @OneToMany(mappedBy = "deliveryByDelivId")
    private Collection<DeliveryDetails> deliveryDetailsByDelivId;

    public int getDelivId() {
        return delivId;
    }

    public void setDelivId(int delivId) {
        this.delivId = delivId;
    }

    public Long getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Long sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(Integer sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getDelivDate() {
        return delivDate;
    }

    public void setDelivDate(String delivDate) {
        this.delivDate = delivDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (delivId != delivery.delivId) return false;
        if (sumPrice != null ? !sumPrice.equals(delivery.sumPrice) : delivery.sumPrice != null) return false;
        if (sumQuantity != null ? !sumQuantity.equals(delivery.sumQuantity) : delivery.sumQuantity != null)
            return false;
        if (customerId != null ? !customerId.equals(delivery.customerId) : delivery.customerId != null) return false;
        if (empId != null ? !empId.equals(delivery.empId) : delivery.empId != null) return false;
        if (delivDate != null ? !delivDate.equals(delivery.delivDate) : delivery.delivDate != null) return false;
        if (note != null ? !note.equals(delivery.note) : delivery.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = delivId;
        result = 31 * result + (sumPrice != null ? sumPrice.hashCode() : 0);
        result = 31 * result + (sumQuantity != null ? sumQuantity.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (delivDate != null ? delivDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public Employee getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Employee employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    public Collection<DeliveryDetails> getDeliveryDetailsByDelivId() {
        return deliveryDetailsByDelivId;
    }

    public void setDeliveryDetailsByDelivId(Collection<DeliveryDetails> deliveryDetailsByDelivId) {
        this.deliveryDetailsByDelivId = deliveryDetailsByDelivId;
    }
}
