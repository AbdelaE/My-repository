package et.gov.empProfile.service;

import et.gov.empProfile.dto.EmployeeResponse;
import et.gov.empProfile.entity.Employee;
import et.gov.empProfile.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> findAllEmp();

    List<EmployeeResponse> getEmpInfo();

    Optional<Employee> findById(int id) throws DataNotFoundException;

    Employee updateEmployee(int id,Employee employee);

    void deleteUser(int id);

}
