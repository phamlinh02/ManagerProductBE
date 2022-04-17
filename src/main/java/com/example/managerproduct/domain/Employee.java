package com.example.managerproduct.domain;

import com.example.managerproduct.dto.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "getEmployee",
        query = " Select e.emp_id empId, e.emp_name empName, e.username username, e.password password, e.email email ," +
                " e.phone phone, e.role role , e.disable disable from employee e " +
                " where e.disable =0",
        resultSetMapping = "getAllEmployee"
)

@SqlResultSetMapping(
        name = "getAllEmployee",
        classes = @ConstructorResult(
                targetClass = EmployeeDTO.class,
                columns = {
                        @ColumnResult(name = "empId", type = Integer.class),
                        @ColumnResult(name = "empName", type = String.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "phone", type = String.class),
                        @ColumnResult(name = "role", type = Integer.class),
                        @ColumnResult(name = "disable", type = Integer.class)
                }
        )

)

@Entity
@Table(name = "employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_id")
    private int empId;
    @Basic
    @Column(name = "emp_name")
    private String empName;
    @Basic
    @Column(name = "role")
    private int role;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "disable")
    private Integer disable;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeByEmpId")
    private Collection<Delivery> deliveriesByEmpId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    private Role roleByRole;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeByEmpId")
    private Collection<Received> receivedsByEmpId;


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        Employee employee = (Employee) o;

        if (empId != employee.empId) return false;
        if (role != employee.role) return false;
        if (empName != null ? !empName.equals(employee.empName) : employee.empName != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (username != null ? !username.equals(employee.username) : employee.username != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (disable != null ? !disable.equals(employee.disable) : employee.disable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (disable != null ? disable.hashCode() : 0);
        return result;
    }

    public Collection<Delivery> getDeliveriesByEmpId() {
        return deliveriesByEmpId;
    }

    public void setDeliveriesByEmpId(Collection<Delivery> deliveriesByEmpId) {
        this.deliveriesByEmpId = deliveriesByEmpId;
    }

    public Role getRoleByRole() {
        return roleByRole;
    }

    public void setRoleByRole(Role roleByRole) {
        this.roleByRole = roleByRole;
    }

    public Collection<Received> getReceivedsByEmpId() {
        return receivedsByEmpId;
    }

    public void setReceivedsByEmpId(Collection<Received> receivedsByEmpId) {
        this.receivedsByEmpId = receivedsByEmpId;
    }


}
