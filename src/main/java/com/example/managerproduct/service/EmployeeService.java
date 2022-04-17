package com.example.managerproduct.service;

import com.example.managerproduct.domain.Employee;
import com.example.managerproduct.dto.EmployeeDTO;
import com.example.managerproduct.response.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

  private final ModelMapper mapper = new ModelMapper();
  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public List<EmployeeDTO> getEmployee() {
    return this.employeeRepository.getAll();
  }

  public List<EmployeeDTO> getByName(String name){
    return this.employeeRepository.getAll().stream()
      .filter(employeeDTO -> employeeDTO.getEmpName().contains(name))
      .collect(Collectors.toList());
  }

  public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
    Employee employee = mapper.map(employeeDTO, Employee.class);
    employee.setPassword("abc@abc");
    return mapper.map(this.employeeRepository.save(employee), EmployeeDTO.class);
  }

  public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, int id) {
    if (this.employeeRepository.findById(id).isPresent()) {
      Employee employee = mapper.map(employeeDTO, Employee.class);
      employee.setPassword(employeeDTO.getPassword());
      employee.setEmail(employeeDTO.getEmail());
      employee.setEmpName(employeeDTO.getEmpName());
      employee.setPhone(employeeDTO.getPhone());
      employee.setRole(employeeDTO.getRole());
      employee.setUsername(employeeDTO.getUsername());

      EmployeeDTO employeeDTO1 = mapper.map(this.employeeRepository.save(employee), EmployeeDTO.class);
      return employeeDTO1;
    } else {
      return null;
    }
  }

  public EmployeeDTO deleteEmployee(int id){
    Employee employee = this.employeeRepository.findEmployeeByEmpId(id);
    employee.setDisable(1);

    employee = this.employeeRepository.save(employee);
    return mapper.map(employee, EmployeeDTO.class);
  }
}
