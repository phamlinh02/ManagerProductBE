package com.example.managerproduct.domain;

import com.example.managerproduct.dto.RoleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@NamedNativeQuery(
        name = "fillCboRole",
        query = "select r.role_id roleId, r.role_name roleName from role r ",
        resultSetMapping = "fillRole"
)

@SqlResultSetMapping(
        name = "fillRole",
        classes = @ConstructorResult(
                targetClass = RoleDTO.class,
                columns = {
                        @ColumnResult(name ="roleId", type = Integer.class),
                        @ColumnResult(name ="roleName", type = String.class)
                }
        )
)

@Entity
@Table(name = "role")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Basic
    @Column(name = "role_name")
    private String roleName;

    @JsonIgnore
    @OneToMany(mappedBy = "roleByRole")
    private Collection<Employee> employeesByRoleId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleId != role.roleId) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    public Collection<Employee> getEmployeesByRoleId() {
        return employeesByRoleId;
    }

    public void setEmployeesByRoleId(Collection<Employee> employeesByRoleId) {
        this.employeesByRoleId = employeesByRoleId;
    }
}
