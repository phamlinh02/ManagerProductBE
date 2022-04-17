package com.example.managerproduct.domain;

import com.example.managerproduct.dto.ReceivedDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "getAllReceived",
        query = "select r.rec_id recId, r.sum_price sumPrice, r.sum_quantity sumQuantity, r.rec_date recDate, e.emp_id empId, e.emp_name empName" +
                "   from received r join employee e on r.emp_id = e.emp_id ",
        resultSetMapping = "getReceived"
)

@SqlResultSetMapping(
        name = "getReceived",
        classes = @ConstructorResult(
                targetClass = ReceivedDTO.class,
                columns = {
                        @ColumnResult(name = "recId", type = Integer.class),
                        @ColumnResult(name ="sumPrice", type = Long.class),
                        @ColumnResult(name ="sumQuantity", type = Integer.class),
                        @ColumnResult(name ="recDate", type = String.class),
                        @ColumnResult(name ="empId", type = Integer.class),
                        @ColumnResult(name = "empName", type = String.class)
                }
        )
)


@Entity
@Table(name = "received")
public class Received {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rec_id")
    private int recId;
    @Basic
    @Column(name = "sum_price")
    private Long sumPrice;
    @Basic
    @Column(name = "sum_quantity")
    private Integer sumQuantity;
    @Basic
    @Column(name = "emp_id")
    private Integer empId;
    @Basic
    @Column(name = "rec_date")
    private String recDate;
    @Basic
    @Column(name = "note")
    private String note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id",  insertable = false, updatable = false)
    private Employee employeeByEmpId;

    @JsonIgnore
    @OneToMany(mappedBy = "receivedByRecId")
    private Collection<ReceivedDetails> receivedDetailsByRecId;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
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

        Received received = (Received) o;

        if (recId != received.recId) return false;
        if (sumPrice != null ? !sumPrice.equals(received.sumPrice) : received.sumPrice != null) return false;
        if (sumQuantity != null ? !sumQuantity.equals(received.sumQuantity) : received.sumQuantity != null)
            return false;
        if (empId != null ? !empId.equals(received.empId) : received.empId != null) return false;
        if (recDate != null ? !recDate.equals(received.recDate) : received.recDate != null) return false;
        if (note != null ? !note.equals(received.note) : received.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recId;
        result = 31 * result + (sumPrice != null ? sumPrice.hashCode() : 0);
        result = 31 * result + (sumQuantity != null ? sumQuantity.hashCode() : 0);
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        result = 31 * result + (recDate != null ? recDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    public Employee getEmployeeByEmpId() {
        return employeeByEmpId;
    }

    public void setEmployeeByEmpId(Employee employeeByEmpId) {
        this.employeeByEmpId = employeeByEmpId;
    }

    public Collection<ReceivedDetails> getReceivedDetailsByRecId() {
        return receivedDetailsByRecId;
    }

    public void setReceivedDetailsByRecId(Collection<ReceivedDetails> receivedDetailsByRecId) {
        this.receivedDetailsByRecId = receivedDetailsByRecId;
    }
}
